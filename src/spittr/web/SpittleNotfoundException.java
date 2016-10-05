package spittr.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 将自定义的异常映射位 HTTP 状态码 404
@ResponseStatus(value=HttpStatus.NOT_FOUND, 
		reason="Spittle Not Found")
public class SpittleNotfoundException extends RuntimeException{

}
