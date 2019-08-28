package com.waiter.sms.push.token.service;

import com.waiter.sms.push.token.component.RestRequest;
import com.waiter.sms.push.token.component.SmsPushProperties;
import com.waiter.sms.push.token.entity.FcmToken;
import com.waiter.sms.push.token.entity.SmsMsg;
import com.waiter.sms.push.token.model.FcmPushMessage;
import com.waiter.sms.push.token.repository.FcmTokenRepository;
import com.waiter.sms.push.token.repository.SmsMsgRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsSendServiceImpl implements SmsSendService {

    private final @NonNull
    SmsMsgRepository smsMsgRepository;

    private final @NonNull
    FcmTokenRepository fcmTokenRepository;

    private final @NonNull
    SmsPushProperties smsPushProperties;
    private final @NonNull
    RestRequest restRequest;

    @Override
    public SmsMsg sendSms(SmsMsg smsMsg) {
        FcmToken fcmToken = this.fcmTokenRepository.findFirstByPhoneOrderByIdDesc(smsMsg.getSendNumber().replaceAll("-", ""));
        if (fcmToken == null) {
            throw new RuntimeException("unauthorization");
        }
        smsMsg.updateSendDate();
        smsMsg.setTokenId(fcmToken.getId());
        smsMsg = this.smsMsgRepository.save(smsMsg);
        FcmPushMessage pushMessage = new FcmPushMessage(fcmToken);
        pushMessage.getMessage().setData(smsMsg);
        this.restRequest.commonRestApiCall(this.smsPushProperties.getFcmApiUrl(), pushMessage.getMessage(), HttpMethod.POST, null, "key=" + this.smsPushProperties.getFcmApiKey(), String.class);

        fcmToken.plusSendCnt();
        this.fcmTokenRepository.save(fcmToken);

        return smsMsg;

    }

    @Override
    public void callback(Long id) {
        SmsMsg smsMsg = this.smsMsgRepository.findById(id).get();
        smsMsg.updateCallbackDate();
        this.smsMsgRepository.save(smsMsg);

        FcmToken fcmToken = this.fcmTokenRepository.findById(smsMsg.getTokenId()).get();
        fcmToken.plusSuccessCnt();
        this.fcmTokenRepository.save(fcmToken);

    }
}
