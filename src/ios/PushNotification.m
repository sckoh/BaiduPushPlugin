//
//  PushNotification.m
//  休假
//
//  Created by soocheng on 6/18/15.
//
//

#import "PushNotification.h"

@implementation PushNotification

- (void) init:(CDVInvokedUrlCommand*)command{
    [self.commandDelegate runInBackground:^{
        NSLog(@"init:");
//        self.userName=[[NSString alloc]initWithFormat:@"%@",[command argumentAtIndex:0]];
//        self.serverUrl=[[NSString alloc]initWithFormat:@"%@",[command argumentAtIndex:1]];
//        
//        self.callid_init=[[NSString alloc] initWithString:[NSString stringWithFormat:@"%@",command.callbackId]];
//        
//        [BPush setDelegate:self];
//        //[[UIApplication sharedApplication] setApplicationIconBadgeNumber:0];
//#if SUPPORT_IOS8
//        if ([[[UIDevice currentDevice] systemVersion] floatValue] >= 8.0) {
//            UIUserNotificationType myTypes = UIRemoteNotificationTypeBadge | UIRemoteNotificationTypeAlert | UIRemoteNotificationTypeSound;
//            UIUserNotificationSettings *settings = [UIUserNotificationSettings settingsForTypes:myTypes categories:nil];
//            [[UIApplication sharedApplication] registerUserNotificationSettings:settings];
//        }else
//#endif
//        {
//            UIRemoteNotificationType myTypes = UIRemoteNotificationTypeBadge|UIRemoteNotificationTypeAlert|UIRemoteNotificationTypeSound;
//            [[UIApplication sharedApplication] registerForRemoteNotificationTypes:myTypes];
//        }
//        //NSLog(@"On bindChannel:");
//        [BPush bindChannel];
    }];
}

@end