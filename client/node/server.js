

var express = require('express');
var httpProxy = require('http-proxy');
var apiProxy = httpProxy.createProxyServer();
var app = express();
// localhost -> dns name
var backend = 'http://waiter-gateway-svc.staging.svc.cluster.local:8000';
var rootPath='/app';
var userPath= rootPath + '/user/';
var admimPath= rootPath +'/admin/';
var port = 80;


const allowedExt = [ '.js', '.ico', '.css', '.png', '.jpg', '.woff2', '.woff', '.ttf', '.svg', '.gif' ];

app.listen(port, function(){ console.log('Waiter Client Starting...'); });

app.all("/logout", function(req, res) {
      proxy(req,res);
});

app.all("/api/*", function(req, res) {
      proxy(req,res);
});




app.get('*', function(req, res) {

      if (allowedExt.filter(ext => req.url.toLowerCase().indexOf(ext) > 0).length > 0) {
              resourceSend(req,res); }
          else{
              sendFile(res, getDistPath(req)+ '/index.html');
          }
});

function getDistPath(req){

    var referer = req.header('Referer');
    if(!referer){
        referer = req.url;
    }
    var distPath = referer.indexOf("admin") >= 0 ? adminPath: userPath;
    return distPath;
}

function redirectUrl(url, res){
    res.setHeader('Location', url);
      res.statusCode = 302;
        res.end();
}

function proxy(req, res){
    apiProxy.web(req, res, {target: backend} , function(err) {
          if (err) console.log(err);
            });
}



function resourceSend(req, res){
    
    var path = getDistPath(req) + req.url;
      if(path.indexOf('?') > 0 ){
            path = path.substr(path, path.indexOf('?'));
              }
        sendFile(res, path);
}


function sendFile(res, path){
      res.sendFile(path, {},function(err) { if (err) console.log(err); } );
}
