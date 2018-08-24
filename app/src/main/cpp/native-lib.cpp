#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring

JNICALL
Java_io_keyss_live555porting_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
