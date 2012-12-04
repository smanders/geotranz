/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class JNISource */

#ifndef _Included_JNISource
#define _Included_JNISource
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     JNISource
 * Method:    JNISourceCount
 * Signature: ()J
 */
JNIEXPORT jlong JNICALL Java_geotrans_jni_JNISource_JNISourceCount
  (JNIEnv *, jobject);

/*
 * Class:     JNISource
 * Method:    JNISourceIndex
 * Signature: (Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_geotrans_jni_JNISource_JNISourceIndex
  (JNIEnv *, jobject, jstring);

/*
 * Class:     JNISource
 * Method:    JNISourceName
 * Signature: (J)Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_geotrans_jni_JNISource_JNISourceName
  (JNIEnv *, jobject, jlong);

/*
 * Class:     JNISource
 * Method:    JNISourcAccuracy
 * Signature: (J)Lgeotrans/Accuracy;
 */
JNIEXPORT jobject JNICALL Java_geotrans_jni_JNISource_JNISourcAccuracy
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif
