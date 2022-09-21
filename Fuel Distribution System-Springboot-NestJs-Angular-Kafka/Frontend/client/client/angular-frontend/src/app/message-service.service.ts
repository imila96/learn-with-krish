import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageServiceService {

  SockJS: any;
  Stomp : any;
  constructor() { 

    this.initializeWebSocketConnection();
  }

  public stompClient;
public msg = [];


  initializeWebSocketConnection() {
    const serverUrl = 'http://localhost:8080/socket';
    const ws = new this.SockJS(serverUrl);
    this.stompClient = this.Stomp.over(ws);
    const that = this;
    // tslint:disable-next-line:only-arrow-functions
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe('/message', (message) => {
        if (message.body) {
          that.msg.push(message.body);
        }
      });
    });
  }



 sendMessage(message) {
  this.stompClient.send('/app/send/message' , {}, message);
}
}
