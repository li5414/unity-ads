//
//  UnityAdsImageViewRoundedCorners.h
//  UnityAds
//
//  Created by Pekka Palmu on 4/18/13.
//  Copyright (c) 2013 Unity Technologies. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface UnityAdsImageViewRoundedCorners : UIView <NSURLConnectionDelegate>
- (void)loadImageFromURL:(NSURL*)url;
- (void)destroyView;
@end
