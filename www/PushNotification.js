var cordova = require('cordova'),
    exec = require('cordova/exec');

var PushNotification = function() {
	this.registered = false;
};
PushNotification.prototype.init = function(api_key, successCallback)
{
    exec(successCallback, PushNotification.failureFn, 'PushNotification', 'init', [api_key]);
};

PushNotification.prototype.failureFn = function() {
	console.log('fail to register push');
};

var PushNotification = new PushNotification();

module.exports = PushNotification;