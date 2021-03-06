## 继承 cordova-progressIndicator 并修改使其适合自己的项目，调用 FileTransfer 上传图片时调用该插件
# 
# Cordova Progress-Indicator Plugin#
This plugin allows you to show a native Progress Indicator on iOS - by [Paolo Bernasconi](https://github.com/pbernasconi)

There are several types of indicators available:

* [Simple](http://pbernasconi.github.io/cordova-progressIndicator/#simple)
* [Determinate](http://pbernasconi.github.io/cordova-progressIndicator/#determinate)
* [Annular](http://pbernasconi.github.io/cordova-progressIndicator/#annular)
* [Bar](http://pbernasconi.github.io/cordova-progressIndicator/#bar)
* [Success](http://pbernasconi.github.io/cordova-progressIndicator/#others)
* [Simple Text](http://pbernasconi.github.io/cordova-progressIndicator/#others)

# Install

```
cordova plugin add org.pbernasconi.progressindicator
```

# [View the Docs](http://pbernasconi.github.io/cordova-progressIndicator/)

The Docs are situated at [http://pbernasconi.github.io/cordova-progressIndicator/](http://pbernasconi.github.io/cordova-progressIndicator/)


## Screenshots

iOS

![ScreenShot](demo/screenshots/simple-large-img.jpg )

|Simple|Label|Label-Detail|Success|Text Top|Text Botom|
|------|-----|------------|-------|--------|----------|
|![](demo/screenshots/simple.jpg)|![](demo/screenshots/simple-label.jpg)|![](demo/screenshots/simple-label-detail.jpg)|![](demo/screenshots/success.jpg)|![](demo/screenshots/text-top.jpg)|![](demo/screenshots/text-bottom.jpg)


|Determinate|Determinate Label|Annular|Annular Label|Bar|Bar Label|
|-----------|-----------------|-------|-------------|---|---------
|![](demo/screenshots/determinate-simple.jpg)|![](demo/screenshots/determinate-label.jpg)|![](demo/screenshots/annular-simple.jpg)|![](demo/screenshots/annular-label.jpg)|![](demo/screenshots/bar-simple.jpg)|![](demo/screenshots/bar-label.jpg)



### CREDITS

 - [MBProgressHUD](https://github.com/jdg/MBProgressHUD)
 - [Cordova-ActivityIndicator](https://github.com/Initsogar/cordova-activityindicator)
 - 
 
#### License

Apache license 2.0 - Use this plugin for any production / development needs, and if you'd like to make an attribution to me somewhere.


#### Upload File  显示上传进度

 
	var ft = new FileTransfer();
  	ft.onprogress = showUploadingProgress;

                function showUploadingProgress(progressEvt) {

                    console.log("showUploadingProgress->上传进度...." + Math.round((progressEvt.loaded / progressEvt.total) * 100));
                    var pro = Math.round((progressEvt.loaded / progressEvt.total) * 100);
                    //ProgressIndicator.showSimple(true);

                    if (device.platform === 'iOS') {
                        ProgressIndicator.showSimpleWithLabelDetail(true, 'Uploading...', pro + "%")

                    } else if (device.platform === 'Android') {
                        ProgressIndicator.show("show", true, 'Uploading...', pro + "% Uploading...")
                    }

                }
