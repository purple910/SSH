

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <a href="Handler\welcome.form">welcome</a>
  <a href="Handler\welcome1.form">welcome1</a>
  <a href="Handler\welcome2\a\aaa.form">welcome2</a>
  <a href="Handler\welcome3\a\b\c\bbb.form">welcome3</a>
  <a href="Handler\welcome4\adc\ccc.form">welcome4</a>
  <a href="Handle\welcome5\ls.form">welcome5</a>
  <br><br><br>

  <form action="Handler/testPost/1231.form" method="post">
    <input type="submit" value="增">
  </form>
  <form action="Handler/testGet/1231.form" method="get">
    <input type="submit" value="查">
  </form>
    <form action="Handler/testDelete/1231.form" method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <input type="submit" value="删">
  </form>
    <form action="Handler/testPut/1231.form" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="改">
  </form>

  <br>
  <form action="/Handler/testParam.form">
    name:<input name="name">
    <input type="submit" value="Param">
  </form>
  <br>
  <a href="/Handler/testRequestHeader.form" >testRequestHeader</a>
  <a href="/Handler/testCookieValue.form">testCookieValue</a>

  <br><br><br><br>
  <form action="/Handler/testEntity.form" method="post">
    id:<input name="id">
    name:<input name="name" >
    age:<input name="age">
    homeAddress:<input name="address.homeAddress">
    schoolAddress:<input name="address.schoolAddress">
    <input type="submit" value="entity">
  </form>
  <hr>
  <form action="Handler/testServeltAPI.form">
    <input name="name">
    <input type="submit" value="servlet">
  </form>

  <hr>
  <a href="/Handler/testModelAndView.form">testModelAndView</a>
  <a href="/Handler/testModelMap.form">testModelMap</a>
  <a href="/Handler/testMap.form">testMap</a>
  <a href="/Handler/testModel.form">testModel</a>
  <hr>

  <form action="/Handler/testModelAttribute.form" method="post">
    id:<input name="id" type="hidden" value="1">
    name:<input name="name" >
    <input type="submit" value="Attribute">
  </form>

    <a href="/Handler/testI18n.form">testI18n</a>

  <a href="/Handler/testViewController.form">ViewController</a>


  <form action="/Handler/testConverter.form" >
    <input name="studentInfo" type="text">
    <input type="submit" value="转换">
  </form>

  <form action="/Handler/testFormatting.form" >
      id:<input name="id">
      name:<input name="name" >
      age:<input name="age">
      date:<input name="brithday">
      <input type="submit" value="Format">
  </form>




  <input type="button" value="testJson" id="testJson">
  <script type="text/javascript" src="./js/jquery-3.3.1.min.js"></script>
  <script type="text/javascript">
    $(function () {
      $("#testJson").click(function () {
        $.post(
                "/Handler/testJson.form",
               // {name:"ls",id:2,age:18},
                function (result) {
                  for(var i=0 ;i<result.length;i++){
                    console.log(result[i].name+"," +result[i].id+","+result[i].age)
                  }
                }
        )
      })
    })
  </script>


  <hr>
  <br>

  <form action="/Handler/testFileUpload.form" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input name="desc">
    <input type="submit" value="upload">
  </form>

  <a href="/second/exception.form">Exception</a>
  <a href="/second/ArrayIndexException.form">ArrayIndexException</a>
  <a href="/second/ArrayIndex.form">ArrayIndex</a>

  <hr>
  <a href="/FormController/testForm.form">testForm</a>
  </body>
</html>
