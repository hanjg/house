<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="itemAddForm" class="itemForm" method="post">
        <textarea style="width:600px;height:100px;" name="state" id="crawlerState" disabled></textarea>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="startCrawler()">开始</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="crawlerStatus()">状态</a>
    </div>
</div>
<script type="text/javascript">
  //提交表单
  function startCrawler() {
    //有效性验证
    if (!$('#itemAddForm').form('validate')) {
      $.messager.alert('提示', '表单还未填写完成!');
      return;
    }
    $.get("crawler/sh/start/1000", null, function (data) {
      var a;
      if (data.status == 200) {
        a = JSON.stringify(data.data);
      } else {
        a = data.msg;
      }
      $('#crawlerState').val(a);
    });
  }

  function crawlerStatus() {
    $.get("crawler/sh/status", null, function (data) {
      var a;
      if (data.status == 200) {
        data.data.startTime = new Date(data.data.startTime);
        a = "爬虫状态：\n" + JSON.stringify(data.data);
      } else {
        a = data.msg;
      }
      $('#crawlerState').val(a);
    });
  }
</script>
