import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from "rxjs/index";
import { ServiceType } from '../common/service-type.enum';

export interface IRequestOptions {
    headers?: HttpHeaders;
    observe?: 'body';
    params?: HttpParams;
    reportProgress?: boolean;
    responseType?: 'json';
    withCredentials?: boolean;
    body?: any;
}

export function applicationHttpClientCreator(http: HttpClient) {
    return new ApplicationHttpClient(http);
}

@Injectable()
export class ApplicationHttpClient {

    // Extending the HttpClient through the Angular DI.
    public constructor(public http: HttpClient) {

    }

    /**
     * GET request
     * @param {string} endPoint it doesn't need / in front of the end point
     * @param {IRequestOptions} options options of the request like headers, body, etc.
     * @returns {Observable<T>}
     */
    public get<T>(serviceType:ServiceType, endPoint: string, options?: IRequestOptions): Observable<T> {
        return this.http.get<T>(serviceType + endPoint, options);
    }

    /**
     * POST request
     * @param {string} endPoint end point of the api
     * @param {Object} params body of the request.
     * @param {IRequestOptions} options options of the request like headers, body, etc.
     * @returns {Observable<T>}
     */
    public post<T>(serviceType:ServiceType,endPoint: string, params: Object, options?: IRequestOptions): Observable<T> {
        return this.http.post<T>(serviceType + endPoint, params, options);
    }

    /**
     * PUT request
     * @param {string} endPoint end point of the api
     * @param {Object} params body of the request.
     * @param {IRequestOptions} options options of the request like headers, body, etc.
     * @returns {Observable<T>}
     */
    public put<T>(serviceType:ServiceType,endPoint: string, params: Object, options?: IRequestOptions): Observable<T> {
        return this.http.put<T>(serviceType + endPoint, params, options);
    }

    /**
     * DELETE request
     * @param {string} endPoint end point of the api
     * @param {IRequestOptions} options options of the request like headers, body, etc.
     * @returns {Observable<T>}
     */
    public delete<T>(serviceType:ServiceType,endPoint: string, options?: IRequestOptions): Observable<T> {
        return this.http.delete<T>(serviceType + endPoint, options);
    }
}
