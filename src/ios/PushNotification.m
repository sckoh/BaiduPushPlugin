//
//  PushNotification.m
//  休假
//
//  Created by soocheng on 6/18/15.
//
//

#import "PushNotification.h"
#import "BPush.h"

@implementation PushNotification

- (void) init:(CDVInvokedUrlCommand*)command{
    [self.commandDelegate runInBackground:^{
        NSLog(@"init");
        
        // iOS8 下需要使用新的 API
        if ([[[UIDevice currentDevice] systemVersion] floatValue] >= 8.0) {
            UIUserNotificationType myTypes = UIUserNotificationTypeBadge | UIUserNotificationTypeSound | UIUserNotificationTypeAlert;
            
            UIUserNotificationSettings *settings = [UIUserNotificationSettings settingsForTypes:myTypes categories:nil];
            [[UIApplication sharedApplication] registerUserNotificationSettings:settings];
        }else {
            UIRemoteNotificationType myTypes = UIRemoteNotificationTypeBadge|UIRemoteNotificationTypeAlert|UIRemoteNotificationTypeSound;
            [[UIApplication sharedApplication] registerForRemoteNotificationTypes:myTypes];
        }
        
        [BPush bindChannelWithCompleteHandler:^(id result, NSError *error) {
            NSLog(@"Method: %@\n%@",BPushRequestMethodBind,result);
            NSData *jsonData=[NSJSONSerialization dataWithJSONObject:result options:NSJSONWritingPrettyPrinted error:&error];
            NSString *jsonString = [[NSString alloc] initWithData:jsonData
                                                         encoding:NSUTF8StringEncoding];
            
            NSString *initSuccessHandler = [NSString stringWithFormat:@"onInitSuccess(%@);", jsonString];
            NSLog(@"initSuccessHandler : %@", initSuccessHandler);
            [self.webView stringByEvaluatingJavaScriptFromString:initSuccessHandler];
        }];

    }];
}

@end