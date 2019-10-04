$(document).ready(function(){
     $("#btn1").on("click",function(){
          var password=  $("#password").val()
          var  newpass1=$("#newpass1").val()
         $.get("#",{password:password,newpass1:newpass1},function(response,status){
                 if(status == "success"){
                     //console.log(result_1.children.pwd);
                      if(response.state==false){
                          alert("密码修改失败");
                      }
                      else{
                          alert("密码修改成功")
                      }
                 }
             })
         })
         $("#btn2").on("click",function(){
              $.get("#",function(response,status){
                  if(status == "success"){
                      response.state=true;
                     if(response.state==false){
                         $("#add1").append("你还未选择题目")
                     }
                     else{
                         $("#add1").append("你已选择题目")
                     }
                  }
              })
         })
       $("#btn3").on("click",function(){
        var password=  $("#password").val()
        var  newpass1=$("#newpass1").val()
        $.get("#",{password:password,newpass1:newpass1},function(response,status){
            if(status == "success"){
                //console.log(result_1.children.pwd);
                if(response.state==false){
                    alert("密码修改失败");
                }
                else{
                    alert("密码修改成功")
                }
            }
        })
    })
})
