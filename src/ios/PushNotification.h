//
//  PushNotification.h
//  休假
//
//  Created by soocheng on 6/18/15.
//
//

#import <Foundation/Foundation.h>
#import <MessageUI/MFMessageComposeViewController.h>
#import <Cordova/CDVPlugin.h>

@interface PushNotification : CDVPlugin

- (void) init:(CDVInvokedUrlCommand*)command;

@end
