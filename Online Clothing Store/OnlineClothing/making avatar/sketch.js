var dd;
let body;
let eyeopen;
let eyeclosed;
let hair;




//DRESS
let dressFront;
let dressSide;
let dressBack;


//ALL FLAGS
let flag=0;
let glassesFlag=0;
let dressFlag=0;
let bodyFlag=0;
let trackglasses=0;
let skinflag=0;


//warning
let warning;

//loads the variable passed from url
function initDD(id,icon,front,side,back){
  n1 =icon;
  n2=front;
  n3=side;
  n4=back
  console.log(n1);
  console.log(n2);
  console.log(n3);
} 

initDD();
//preloads all the images to prevent lagging
function preload(){

//BODY 

//medium tone
  body=loadImage('body/modelbody.png');
  bodyY=loadImage('body/modelbodyY.png');
  bodyZ=loadImage('body/modelbodyZ.png');
  skin2=loadImage('skin/skin2.png');

//light tone
  body30 = loadImage('body/modelbody30.png');
  bodyY30 = loadImage('body/modelbodyY30.png');
  bodyZ30 =loadImage('body/modelbodyZ30.png');
  skin1=loadImage('skin/skin1.png');

//dark tone
  body60=loadImage('body/modelbody60.png');
  bodyY60=loadImage('body/modelbodyY60.png');
  bodyZ60=loadImage('body/modelbodyZ60.png');
  skin3=loadImage('skin/skin3.png');


  //EYES
  eyeopen=loadImage('body/eyeopen.png');
  eyeclosed=loadImage('body/eyesclosed.png');

  //HAIR
  hair1=loadImage('hair/hair2.png');
  hairicon1=loadImage('hair/hair2.png');
  hair1Y=loadImage('hair/hair2Y.png');
  hair1Z=loadImage('hair/hair2Z.png');


  hair2=loadImage('hair/hair3.png');
  hairicon2=loadImage('hair/hair3.png');
  hair2Y=loadImage('hair/hair3Y.png');
  hair2Z=loadImage('hair/hair3Z.png');


  hair3=loadImage('hair/hair4.png');
  hairicon3=loadImage('hair/hair4icon.png');
  hair3Y=loadImage('hair/hair4Y.png');
  hair3Z=loadImage('hair/hair4Z.png');

  //GLASSES
  glasses1=loadImage('glasses/glasses1.png');
  glassesicon1=loadImage('glasses/glasses1.png');
  glasses2=loadImage('glasses/glasses2.png');
  glassesicon2=loadImage('glasses/glasses2.png');
  glasses3=loadImage('glasses/glasses3.png');
  glassesicon3=loadImage('glasses/glasses3.png');


  //DRESSES
  if(n1!=""){
  dressFront=loadImage(n1);
   }
   if(n2!=""){
  dressicon=loadImage(n2);
   }
   if (n3!="") {
   dessSide=loadImage(n3);
   }
   if(n4!="")
   {
    dressBack=loadImage(n4);
   }


  //ICONS
  rightarrow=loadImage('symbols/rightarrow.png');
  leftarrow=loadImage('symbols/leftarrow.png');


  //WARNING
  warning = loadImage('symbols/warning.png')
}

//canvas size
function setup() {
  canvas=createCanvas(1500, 1100);
  canvas.position(650,100);

  //BUTTON
  button=createButton('Reset');
  button.size(150,60);
  button.position(830,1120);
  button.mousePressed(reset);

}

function reset()
{
  flag=0;
  glassesFlag=0;
  dressFlag=0;
  bodyFlag=0;
}

let rightarrow;
let leftarrow;
function arrow()
{
  image(rightarrow,410,880);
  rightarrow.resize(50,50);
  image(leftarrow,50,880);


}


var i=230;//Blinks in every 230 interval
function draw() {
  background(220);
  arrow();

//BODY


if (skinflag==0) {
if(bodyFlag==0){
  image(body,0,0);
}



else if(bodyFlag==1){
  image(bodyY,0,0);
  glassesFlag=0;
  
}
else if(bodyFlag==2)
{
  image(bodyZ,0,0);
  glassesFlag=0;
  
}

}


if (skinflag==1) {
if(bodyFlag==0){
  image(body30,0,0);
}



else if(bodyFlag==1){
  image(bodyY30,0,0);
  glassesFlag=0;
  
}
else if(bodyFlag==2)
{
  image(bodyZ30,0,0);
  glassesFlag=0;
  
}

}



if (skinflag==2) {
if(bodyFlag==0){
  image(body60,0,0);
}



else if(bodyFlag==1){
  image(bodyY60,0,0);
  glassesFlag=0;
  
}
else if(bodyFlag==2)
{
  image(bodyZ60,0,0);
  glassesFlag=0;
  
}

}


//DRESS
textSize(50);
text('Outfit', 550, 880);
if(dressFlag==1 && bodyFlag==0){
if(dressFront!=null){
image(dressFront,0,0);
}
else
{
  image(warning,0,0);
}
}


if(dressFlag==1 && bodyFlag==2)
{
  if (dressBack!=null) {
  image(dressBack,0,0);
        }
        else{
          image(warning,0,0);
        }
}

if(dressFlag==1 && bodyFlag==1)
{
  if(dressSide!=null)
  {
    image(dressSide,0,0);
  }
  else{
    image(warning,0,0);
  }
}



  image(dressicon,500,865);
  dressicon.resize(250,220);
  

//HAIR
    textSize(50);
    text('Hair', 530, 90);
    noStroke();
    rect(530,120,150,150,25,255);
    image(hairicon1,495,100);//the hair option
    hairicon1.resize(200, 200);
   

      
      
    noStroke();
    rect(770,120,150,150,25,255);
    image(hairicon2,785,110);//the hair option
    hairicon2.resize(120, 170);

   
    noStroke();
    rect(1010,120,150,150,25,255);
    image(hairicon3,1020,115);//the hair option
    hairicon3.resize(120, 150);




//all hair conditions   
if(flag == 1 && bodyFlag==0)
{
	  
image(hair2,100,-5);
	  
}
else if(flag ==1 && bodyFlag==1)
{
  image(hair2Y,0,0);
}
else if(flag==1 && bodyFlag==2)
{
  image(hair2Z,0,0);
}

else if(flag ==2 && bodyFlag==0)
{
    image(hair1,70,-5);
}

else if (flag==2 && bodyFlag==1)
{
    image(hair1Y,140,30);
    hair1Y.resize(260,310);
    glassesFlag=0;
}

else if(flag == 2 && bodyFlag==2)
{
  image(hair1Z,0,0);
}


else if(flag==3 && bodyFlag==0)
{
  image(hair3,0,0);
}

else if(flag==3 && bodyFlag==1)
{
  image(hair3Y,0,0);
}

else if(flag==3 && bodyFlag==2)
{
  image(hair3Z,0,0);
}

//OUTPUT OF ALL FLAGS
console.log(flag);
console.log(bodyFlag);

  
//BLINKING
  

  
if(bodyFlag==0){
  i=i-1;
if(i<20){
    image(eyeclosed,113,63)
    if(i==0)
    {
      i=230;
    }
  }

  else{
      image(eyeopen,83,84);  
  }
}

  //GLASSES

    textSize(50);
    text('Glasses', 530, 350);
    
    var x=550;
    for(loop=0;loop<3;loop++)
    {
       rect(x,390,150,150,25,255);
       x=x+250;
    }

    image(glassesicon1,550,390);
    image(glassesicon2,800,400);
    image(glassesicon3,1030,380);


 
if (glassesFlag==1) {
    image(glasses1,165,110);
}
else if (glassesFlag==2) {
    image(glasses2,173,122);
}
else if (glassesFlag==3) {
    image(glasses3,150,102);
}




//SKIN



textSize(50);
text('Skin', 540, 610);
var xLoop2=550;

for(loop2=0;loop2<3;loop2++)
{
  rect(xLoop2,650,150,150,25,255);
  xLoop2=xLoop2+250;
}

image(skin1,560,640);
image(skin2,800,660);
image(skin3,1055,665);


console.log('skin:'+skinflag);

}


  function mousePressed(){
    
 //Hair   
  if(mouseX>=770 && mouseX<=920 && mouseY>=20 && mouseY<=270){
    
	flag = 1;
	

  }
    
  else if(mouseX>=530 && mouseX<=680 && mouseY>=20 && mouseY<=270){
		
	flag = 2;
		
  }

  else if(mouseX>=1020 && mouseX<=1170 && mouseY>=115 && mouseY<=265)
  {
    flag=3;
  }

 
 //Glasses
  
  if(mouseX>=550 && mouseX<=750 && mouseY>=420 && mouseY<=570)
  {
    glassesFlag=1;
    trackglasses=1;
  }
 
  else if(mouseX>=800 && mouseX<=950 && mouseY>=420 && mouseY<=570)
  {
   glassesFlag=2; 
   trackglasses=2;
  }
  else if(mouseX>=1050 && mouseX<=1200 && mouseY>=420 && mouseY<=570)
  {
    glassesFlag=3;
    trackglasses=3;
  }

 //Dress

 if(mouseX>=550 && mouseX<=700 && mouseY>=900 && mouseY<=1050)
 {
  dressFlag=1;
 }



 if(mouseX>=550 && mouseX<=700 && mouseY>=650 && mouseY<=800)
 {
  skinflag=1;
 }
 else if(mouseX>=800 && mouseX<=950 && mouseY>=650 && mouseY<=800)
 {
  skinflag=0;
 }
 else if(mouseX>=1050 && mouseX<=1200 && mouseY>=650 && mouseY<=800)
 {
  skinflag=2;
 }

//BODY
if((mouseX>=410 && mouseX<=460 && mouseY>=880 && mouseY<=930 && dressFlag!=0) ||( mouseX>=50 && mouseX<=100 && mouseY>=880 && mouseY<=930 && dressFlag!=0))
{ 
  if(bodyFlag==0)
  {
    bodyFlag=1;
  }
  else if(bodyFlag==1)
  {
    bodyFlag=2;
  }
  else if (bodyFlag==2) {
    bodyFlag=0;
    dressFlag=1;
    glassesFlag=trackglasses;
  }
}




  }


