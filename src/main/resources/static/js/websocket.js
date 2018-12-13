var websocket = null;
if ('WebSocket' in window) {
  //Websocket的连接
  websocket = new WebSocket("ws://" + host_port
      + "/house/websocket/socketServer.do");//WebSocket对应的地址
}
else if ('MozWebSocket' in window) {
  //Websocket的连接
  websocket = new MozWebSocket("ws://" + host_port
      + "/house/websocket/socketServer.do");//SockJS对应的地址
}
else {
  //SockJS的连接
  websocket = new SockJS("http://" + host_port
      + "/house/sockjs/socketServer.do");    //SockJS对应的地址
}
websocket.onopen = onOpen;
websocket.onmessage = onMessage;
websocket.onerror = onError;
websocket.onclose = onClose;
var heartbeat = window.setInterval(doSend, 10000);

function onOpen() {
//    alert("hello");
}

function onMessage(evt) {
  alert(evt.data);
  // $('#push').text(evt.data);
}

function onError() {
}

function onClose() {
}

function doSend() {
  if (websocket.readyState == websocket.OPEN) {
    var msg = "alive";
    websocket.send(msg);//调用后台handleTextMessage方法
    console.log("heart beat!");
  }
}

window.close = function () {
  websocket.close();
  window.clearInterval(heartbeat);
}