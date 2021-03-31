# NavigationBarKit

## YdKit通用组件库
YdKit 是一组功能丰富的 Android 通用组件。

* [LogKit](https://github.com/ydstar/LogKit) — 轻量级的 Android 日志系统。
* [RestfulKit](https://github.com/ydstar/RestfulKit) — 简洁但不简单的 Android 网络组件库。
* [StorageKit](https://github.com/ydstar/StorageKit) — 高性能 Android 离线缓存框架。
* [ExecutorKit](https://github.com/ydstar/ExecutorKit) — 简洁易用的 Android 多线程操作框架。
* [CrashKit](https://github.com/ydstar/CrashKit) — 简洁易用的 Android Crash日志捕捉组件。
* [PermissionKit](https://github.com/ydstar/PermissionKit) — 简洁易用的 Android 权限请求组件。
* [NavigationBarKit](https://github.com/ydstar/NavigationBarKit) — 简洁易用的 Android 顶部导航条组件。
* [RefreshKit](https://github.com/ydstar/RefreshKit) — 简洁易用的 Android 下拉刷新和上拉加载组件。
* [AdapterKit](https://github.com/ydstar/AdapterKit) — 简洁易用的 Android 列表组件。
* [BannerKit](https://github.com/ydstar/BannerKit) — 简洁易用的 Android 无限轮播图组件。
* [TabBottomKit](https://github.com/ydstar/TabBottomKit) — 简洁易用的 Android 底部导航组件。
## 效果预览

<img src="https://github.com/ydstar/NavigationBarKit/blob/main/preview/show.jpeg" width="250px">

顶部导航条组件

## 导入方式

仅支持`AndroidX`
```
dependencies {
     implementation 'com.android.ydkit:navigationbar-kit:1.0.0'
}
```

## 使用方法
#### 关于矢量图标的制作和使用,可以参考[矢量字体图标制作并使用](https://www.jianshu.com/p/432d3b23384c)
#### 1.创建style,demo中提供了defaultStyle
```java
    <!-- 默认属性配置-->
    <style name="NavigationBarKitDefaultStyle">
        <!-- 返回按钮文本,大小,颜色(使用iconfont)-->
        <item name="nav_icon">@string/back</item>
        <item name="nav_icon_size">20sp</item>
        <item name="nav_icon_color">#000000</item>

        <!-- 中间主标题的大小和颜色,以及出现副标题时主标题的大小-->
        <item name="title_text_size">18sp</item>
        <item name="title_text_color">#000000</item>
        <item name="title_text_size_with_subTitle">16sp</item>

        <!-- 副标题大小颜色-->
        <item name="subTitle_text_size">14sp</item>
        <item name="subTitle_text_color">#717882</item>

        <!-- 添加的按钮的大小颜色(使用iconfont)-->
        <item name="text_btn_text_size">16sp</item>
        <item name="text_btn_text_color">#333333</item>

        <!-- 按钮的横向内间距-->
        <item name="hor_padding">8dp</item>
        <!-- 底部的横线-->
        <item name="nav_line_color">#eeeeee</item>
        <item name="nav_line_height">2px</item>
    </style>
```

#### 该NavigationBarKitDefaultStyle可以直接定义在AppTheme中
```java
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <item name="NavigationBarKitStyle">@style/NavigationBarKitDefaultStyle</item>
    </style>
```

#### 如果在布局中再次添加 style="@style/NavigationBarKitDefaultStyle",则会覆盖掉AppTheme定义的style
#### 2.在布局中添加
```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#fff"
    android:gravity="center"
    android:orientation="vertical">

    <com.navigationbar.kit.NavigationBarKit
        android:id="@+id/nav_bar"
        style="@style/NavigationBarKitDefaultStyle"
        android:layout_width="match_parent"
        android:layout_height="45dp" />

</LinearLayout>

```


## NavigationBarKi具体方法作用
| 方法      |返回值  | 参数  |  作用  |
| :-------- | :--------| :--------| :--: |
| setNavBackListener| void  |OnClickListener  |  设置返回按钮并监听其点击事件 |
| addLeftTextButton|  Button  |stringRes: Int, viewId: Int |  添加左侧按钮 |
| addLeftTextButton|  Button  |buttonText: String, viewId: Int |  添加左侧按钮 |
| addLeftView|  void  |view: View,params: LayoutParams |  添加左侧自定义view |
| addRightTextButton|  Button  |stringRes: Int, viewId: Int |  添加右侧按钮 |
| addRightTextButton|  Button  |buttonText: String, viewId: Int |  添加右侧按钮 |
| addRightView|  void  |view: View,params: LayoutParams |  添加右侧自定义view |
| setTitle|  void  |title: String |  添加主标题 |
| setSubtitle|  void  |subtitle: String |  添加副标题 |
| setCenterView|  void  |view: View |  中间的自定义view |


## License
```text
Copyright [2021] [ydStar]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
