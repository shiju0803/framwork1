**1.自定义异常处理**

    异常处理【理解】

    【第一步】通过自定义异常类将我们的原始异常进行分类
    业务异常：BusinessException，通常是用户的不合法输入导致的异常，应该告知用户。
    系统异常：SystemException，给用户一个友好的提示信息，将异常记录到数据库/文件中,通知运维和开发人员。
    其他异常：Exception，给用户一个友好的提示信息，将异常记录到数据库/文件中,通知开发人员。
    
        public class BusinessException extends RuntimeException{
            //重写所有构造方法
        }

    【第二步】定义异常处理的通知类
    @ControllerAdvice
    public class ProjectExceptionAdvice{
    
            @ExceptionHandler(BusinessException.class)
            @ResponseBody
            public String doBusinessException(BusinessException e){
                //通常是用户的不合法输入导致的异常，应该告知用户。
            }
            
            @ExceptionHandler(SystemException.class)
            @ResponseBody
            public String doSystemException(SystemException e){
                //给用户一个友好的提示信息，将异常记录到数据库/文件中,通知运维和开发人员。
            }
            
            @ExceptionHandler(Exception.class)
            @ResponseBody
            public String doException(Exception e){
                //给用户一个友好的提示信息，将异常记录到数据库/文件中,通知开发人员。
            }
        }

    【第三步】在自己的后台代码中将原始异常转换成自定义异常并抛出

**2.springMVC整合文件上传**

     文件上传
    
    【第一步】添加依赖commons-fileupload
    【第二步】在springmvc配置文件中配置CommonsMultipartResolver,id必须叫做multipartResolver
    【第三步】在controller的方法中将上传的文件写到服务器硬盘中
	