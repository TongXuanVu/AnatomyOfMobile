# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\manus\AppData\Local\Android\Sdk\tools\proguard\proguard-android-optimize.txt
# You can also load additional configuration files with the '-include'
# option.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamelocals

# Add rules to keep the SQLite database helper and model classes
-keep class com.example.androidauthapp.DatabaseHelper { *; }
-keep class com.example.androidauthapp.User { *; }
-keep class com.example.androidauthapp.MainActivity { *; }
-keep class com.example.androidauthapp.LoginActivity { *; }
-keep class com.example.androidauthapp.RegisterActivity { *; }

# Keep all classes in the application package and their members
-keep class com.example.androidauthapp.** { *; }

# Keep all custom views
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(...);
}
