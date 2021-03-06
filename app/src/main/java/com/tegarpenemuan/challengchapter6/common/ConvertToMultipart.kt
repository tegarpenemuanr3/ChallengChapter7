package com.tegarpenemuan.challengchapter6.common

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File

object ConvertToMultipart {
    fun File?.toMultipartBody(name: String = "image"): MultipartBody.Part? {
        if (this == null) return null
        val reqFile: RequestBody = this.asRequestBody("image/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData(name, this.name, reqFile)
    }

    fun File?.toAudioMultipartBody(): MultipartBody.Part? {
        if (this == null) return null
        val reqFile: RequestBody = this.asRequestBody("audio/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("audio", this.name, reqFile)
    }

    fun File?.toPdfMultipartBody(): MultipartBody.Part? {
        if (this == null) return null
        val reqFile: RequestBody = this.asRequestBody("application/pdf".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("audio", this.name, reqFile)
    }
}