package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制器通知类
 * 1.作用于所有控制器
 * 
 * @author 钟浩
 *
 */
@ControllerAdvice
public class AppWideExceptionHandler {

	// 用于处理出现 SpittleNotfoundException 异常
	@ExceptionHandler(SpittleNotfoundException.class)
	public String absentSpittleHandler() {
		return "error/absent";
	} 
	
}
