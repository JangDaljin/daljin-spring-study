package daljin.spring.study.response

data class RestResponseDto<T>(
    val body: T
) {}