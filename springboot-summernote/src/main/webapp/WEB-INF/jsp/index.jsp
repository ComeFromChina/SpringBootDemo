<%--
  Created by IntelliJ IDEA.
  User: BJ638
  Date: 2021/4/21
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/font-awesome.min.css">
    <link rel="stylesheet" href="/css/default.css">

    <!-- summernote富文本编辑器插件 -->
    <link href="/libs/summernote/summernote.css" rel="stylesheet"/>
    <link href="/libs/summernote/summernote-bs4.css" rel="stylesheet"/>

    <!-- datetimepicker日期和时间插件 -->
    <link href="/libs/datapicker/bootstrap-datetimepicker.min.css" rel="stylesheet"/>
    <script src="/js/jquery-1.11.3.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <!-- summernote富文本编辑器插件 -->
    <script src="/libs/summernote/summernote.min.js"></script>
    <script src="/libs/summernote/lang/summernote-zh-CN.js"></script>
    <!-- datetimepicker日期和时间插件 -->
    <script src="/libs/datapicker/bootstrap-datetimepicker.min.js"></script>
    <style type="text/css">
        .main{
            width: 1200px;
            height: auto;
            margin: 20px auto;
            padding: 20px;
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <div class="main">
        <form method="post" id="form1" action="" class="form-horizontal">

            <div class="form-group">
                <label class="col-sm-2 control-label">标题</label>
                <div class="col-sm-4">
                    <input type="text" name="title" id="title" class="form-control" value="${obj.title}" required>
                </div>
            </div>
            <div class="hr-line-dashed"></div>

            <div class="form-group">
                <label class="col-sm-2 control-label">来源</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="noticeSource" id="noticeSource" value="" required><!--
                                <span class="help-block m-b-none">帮助文本，可能会超过一行，以块级元素显示</span>
                            --></div>
            </div>
            <div class="hr-line-dashed"></div>

            <div class="form-group">
                <label class="col-sm-2 control-label">发布日期</label>
                <div class="col-sm-4">
                    <div class="input-group date form_date">
                        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
                        <input class="form-control" size="16" type="text" name="releaseDate" id="releaseDate" value="">
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                    </div>
                </div>
            </div>
            <div class="hr-line-dashed"></div>

            <div class="form-group">
                <label  class="col-sm-2 control-label">内容</label>
                <div class="col-sm-10">
                    <textarea  id="content" name="content"> </textarea>
                </div>
            </div>
            <div class="hr-line-dashed"></div>

            <div class="form-group">
                <label class="col-sm-2 control-label">备注</label>
                <div class="col-sm-4">
                    <input type="text" class="form-control" name="remark" id="remark" value="${obj.remark}">
                </div>
            </div>
            <div class="hr-line-dashed"></div>

            <div class="form-group">
                <label class="col-sm-2 control-label"></label>
                <div class="col-sm-9">
                    <button class="btn btn-primary pull-right" type="button" id="formSubmitBtn">保存内容</button>
                    <a href="#"><button class="btn btn-white pull-right marginR10" type="button">返回</button></a> </div>
            </div>
        </form>
    </div>





    <script>
        $(function(){
            //初始化相关插件
            init();
        })

        function init(){
            //富文本编辑器配置
            $('#content').summernote({
                placeholder: '请填写内容',
                lang:'zh-CN',
                height: 200,
                toolbar: [
                    ['style', ['style']],
                    ['font', ['bold','italic', 'underline', 'clear','hr']],
                    ['fontname', ['fontname']],
                    ['superscript', ['strikethrough','superscript','subscript']],
                    ['height', ['height','fontsize']],
                    ['color', ['color']],
                    ['para', ['ul', 'ol', 'paragraph']],
                    ['table', ['table']],
                    ['insert', ['link', 'picture', 'video']],
                    ['view', ['undo','redo', 'fullscreen', 'codeview','help']]
                ]
            });

            //日期选择控件
            $('.form_date').datetimepicker({
                format: "yyyy-mm-dd",
                minView: "month",
                todayBtn: true,
                autoclose: true
            });
        }
    </script>
</body>

</html>
