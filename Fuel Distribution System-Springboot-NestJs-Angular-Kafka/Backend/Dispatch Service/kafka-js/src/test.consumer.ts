import { Injectable, OnModuleInit } from '@nestjs/common';
import { Script } from 'vm';
import { ConsumerService } from './kafka/consumer.service';
import { Order } from './model/order.service';
import { ProductsService } from './products/products.service';
import { ProductsController } from './products/products.controller';


@Injectable()
export class TestConsumer implements OnModuleInit {

  
  static Arrc: any[];
  constructor(private readonly consumerService: ConsumerService,private readonly productService: ProductsService) {}
  

  torderId : string;
  tstatus : string;
  tdate : Date;

  x11 : string="11qqww22";
  x22 :string="pending";
  x33: Date=new Date(2022-11-18);

  ps : ProductsService;
   
  async onModuleInit() {
    await this.consumerService.consume(
      
      { topic: 'scheduler_topic' },
      {
        eachMessage: async ({ topic, partition, message }) => {
          console.log({
            value: message.value.toString()
            
          });

          var str=message.value.toString();
          var splitted = str.split(" "); 

          var s1=splitted[0].toString();
          var s2=splitted[1].toString();
          var s3=splitted[2].toString();
          var s4=splitted[3].toString();
          var s5=splitted[4].toString();
          var s6=splitted[5].toString();

          var x1=s1.substring(32,(s1.length-1));
          var x2=s2.substring(9,(s2.length-1));
          var x3=s3.substring(4,(s3.length-1));
          var x3no=Number(x3);
          var x4=s4.substring(7,(s4.length-1));
          var x5=s5.substring(9,(s5.length-1));
          var x6=s6.substring(5,(s6.length-2));
          var mydate = new Date(x6);

          
         
          let Arr = [];
          Arr[0]=x1;
          Arr[1]=x2;
          Arr[2]=x3;
          Arr[3]=x4;
          Arr[4]=x5;
          Arr[5]=x6;
          


          
          Order.setOrderId(x1);
          Order.setFuelType(x2);
          Order.setQty(x3no);
          Order.setStatus(x4);
          Order.setDate(mydate);

          console.log(Order.getOrderId());
          console.log(Order.getFuelType());
          console.log(Order.getQty());
          console.log(Order.getStatus());
          console.log(Order.getDate());
         
         

          let x=Order.getOrderId();
         let y=Order.getStatus();
          let z=Order.getDate();
          

       this.torderId=x;
       ProductsService.porderId=this.torderId;
       
       this.tstatus=y;
       ProductsService.pstatus=this.tstatus;

       this.tdate=z;
       ProductsService.pdate=this.tdate;

      

       //this.ps.insertProduct(this.x11,this.x11,this.x22,this.x33);
       this.productService.insertProduct(this.torderId,this.torderId,this.tstatus,mydate);
          
          
            
        },
       
      },
      
      
    );
    
  }

}