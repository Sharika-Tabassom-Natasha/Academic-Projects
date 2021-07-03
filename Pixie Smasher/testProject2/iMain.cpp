# include "iGraphics.h"
#include<stdio.h>
#include<time.h>
#include<stdlib.h>
#include<string.h>
#define evilPixie 5
#define bigPixie 1
#define goodPixie 1
#define COIN 3
#define LIFE1 1

void mainbuttonSet();
void subbuttonSet();
void pixieSet();
void setscore();
void setname(int nameindex);
void disapear(int a, int b);
void display(int a, int b);


char mainButton[3][20]={"picture\\b1.bmp","picture\\b2.bmp","picture\\b3.bmp"};
char subButton[3][20]={"picture\\b4.bmp","picture\\b5.bmp","picture\\b6.bmp"};
char start[30]="picture\\start.bmp";
char bc[30]="picture\\bc.bmp";
char play[30]="picture\\play.bmp";
char flower[30]="picture\\flower.bmp";
char hscore[30]="picture\\hscore.bmp";
char instruction[30]="picture\\instruction.bmp";
char back[30]="picture\\back.bmp";
char gameover[30]="picture\\gameover.bmp";
char evil[20]="picture\\e2.bmp";
char big[20]="picture\\e1.bmp";
char good[20]="picture\\g4.bmp";
char Coin[20]="picture\\coin.bmp";
char Life1[20]="picture\\life.bmp";
bool musicOn=true;

struct bcbutton{
	int x;
	int y;
}mainbutton[3],subbutton[3];

struct pixie
{
	int x;
	int y;
	bool disapear;
	int speed;
}ePixie[evilPixie],bPixie[bigPixie],gPixie[goodPixie],coin[COIN],life1[LIFE1];

int buttonIndex=-2;
bool gameOver;
int bigPixieLife;
char str4[5][40];
char str3[5][40];
int life,score;
char Life[20],Score[20];
char str[100], str2[100];
int mode;
int len;
void drawTextBox()
{
	iSetColor(100,45, 100);
	iFilledRectangle(150, 250, 250, 30);
}
void PixieShow()
{
	iSetColor(0, 0, 0);
	iText(500,550 , Life,GLUT_BITMAP_TIMES_ROMAN_24);
	sprintf(Life,"life:%d",life);
	iText(500,520 , Score,GLUT_BITMAP_TIMES_ROMAN_24);
	sprintf(Score,"score:%d",score);
	for(int i=0;i<evilPixie;i++)
	{
		if(ePixie[i].disapear==false)
		{
			iShowBMP2(ePixie[i].x,ePixie[i].y,evil,0);
		}
		else
	    {
        	ePixie[i].x=rand()%450;
	        ePixie[i].y=650;
	        iShowBMP2(ePixie[i].x,ePixie[i].y,evil,0);
			ePixie[i].disapear=false;
	
	    }
}


	for(int i=0;i<bigPixie;i++)
	{
	if(bPixie[0].disapear==false)
		{
			iShowBMP2(bPixie[0].x,bPixie[0].y,big,0);
		}
		else
	    {
        	bPixie[i].x=rand()%450;
	        bPixie[i].y=1500;
	        iShowBMP2(bPixie[i].x,bPixie[i].y,big,0);
			bPixie[i].disapear=false;
	
	    }
	}

		for(int i=0;i<goodPixie;i++)
	{
		if(gPixie[i].disapear==false)
		{
			iShowBMP2(gPixie[i].x,gPixie[i].y,good,0);
		}
		else 
			life=0;
	}




		for(int i=0;i<COIN;i++)
	    {
		if(coin[i].disapear==false)
		{
			iShowBMP2(coin[i].x,coin[i].y,Coin,0);
		}
		else
	    {
			coin[i].x=rand()%450;
	        coin[i].y=1500;
	        iShowBMP2(coin[i].x,coin[i].y,Coin,0);
			coin[i].disapear=false;
	
	    }
		}

		for(int i=0;i<LIFE1;i++)
	    {
		if(life1[i].disapear==false)
		{
			iShowBMP2(life1[i].x,life1[i].y,Life1,0);
		}
		else
	    {
			life1[i].x=rand()%450;
	        life1[i].y=1500;
	        iShowBMP2(life1[i].x,life1[i].y,Life1,0);
			life1[i].disapear=false;
	
	    }
		}




}

void ePixieMove()
{
	
	for(int i=0;i<evilPixie;i++)
	{
		ePixie[i].y-=5;
		ePixie[i].x-=ePixie[i].speed;

		if(ePixie[i].x<=5 || ePixie[i].x>=400)
	   {
		   ePixie[i].speed = ePixie[i].speed * -1;

	   }

		if(ePixie[i].y<=65)
		{
			ePixie[i].x=5 +rand()%400;
			ePixie[i].y=600;
			life--;
		}
	}
}

void bPixieMove()
{
	
	for(int i=0;i<bigPixie;i++)
	{
		bPixie[i].y-=5;
		bPixie[i].x-=bPixie[i].speed;

		if(bPixie[i].x<=5 || bPixie[i].x>=400)
	   {
		   bPixie[i].speed = bPixie[i].speed * -1;

	   }

		if(bPixie[i].y<=65)
		{
			bPixie[i].x=5 +rand()%400;
			bPixie[i].y=1500;
			life=0; 
		}
	}
}

void gPixieMove()
{
	
	for(int i=0;i<goodPixie;i++)
	{
		gPixie[i].y-=5;
		gPixie[i].x-=gPixie[i].speed;

		if(gPixie[i].x<=5 || gPixie[i].x>=400)
	   {
		   gPixie[i].speed = gPixie[i].speed * -1;

	   }

		if(gPixie[i].y<=65)
		{
			gPixie[i].x=5 +rand()%400;
			gPixie[i].y=1000;
		}
	}
}

void coinMove()
{
	
	for(int i=0;i<COIN;i++)
	{
		coin[i].y-=5;
		//coin[i].x-=coin[i].speed;

		/*if(coin[i].x<=5 || coin[i].x>=400)
	   {
		   coin[i].speed = coin[i].speed * -1;

	   }*/

		if(coin[i].y<=65)
		{
			coin[i].x=5 +rand()%400;
			coin[i].y=1500;
		}
	}
}

void lifeMove()
{
	
	for(int i=0;i<LIFE1;i++)
	{
		life1[i].y-=5;
		life1[i].x-=coin[i].speed;

		if(life1[i].x<=5 || life1[i].x>=400)
	   {
		   life1[i].speed = life1[i].speed * -1;

	   }

		if(life1[i].y<=65)
		{
			life1[i].x=5 +rand()%400;
			life1[i].y=2000;
		}
	}
}

void backGroundShow()
{
	iPauseTimer(0);
	iPauseTimer(1);
	iPauseTimer(2);
	iPauseTimer(3);
	iPauseTimer(4);
	drawTextBox();
	  if(mode == 1)
	  {
		iSetColor(255,255,255);
		iText(155, 265, str);
	  }

	iText(10, 10, "Click to activate the box, enter to finish.");
	
}

void Menu()
{
	life=3;
	score=0;
	iPauseTimer(0);
	iPauseTimer(1);
	iPauseTimer(2);
	iPauseTimer(3);
	iPauseTimer(4);
	iShowBMP(0,0,bc);
	
	for (int i=0; i<3;i++)
	{
		iShowBMP2(mainbutton[i].x,mainbutton[i].y,mainButton[i],0);
	}  
}


void Play()
{
	iShowBMP(0,0,play);
		iShowBMP2(0,0,flower,0);
		iResumeTimer(0);
		iResumeTimer(1);
		iResumeTimer(2);
		iResumeTimer(3);
		iResumeTimer(4);
		PixieShow();
		if(life<=0)
		{
			iPauseTimer(0);
			iPauseTimer(1);
			iPauseTimer(2);
			iPauseTimer(3);
			iPauseTimer(4);
			pixieSet();
			gameOver = true;
		}

		iSetColor(0,0,0);
		iText(500,140,"press",GLUT_BITMAP_TIMES_ROMAN_24);
		iText(500,120,"backspace",GLUT_BITMAP_TIMES_ROMAN_24);
		iText(500,100,"to pause",GLUT_BITMAP_TIMES_ROMAN_24);
}

int Hscore[5];
int tempvalue=0;
int index;
void setscore()
{
	int i;
	FILE *fread;
	fread= fopen("Newscore.txt","r");
	for(i=0;i<5;i++)
	{
		fscanf(fread,"%d",&Hscore[i]);
	}
	fclose(fread);
	for(i=0;i<5;i++)
    {
		
        if(Hscore[i]<score)
        {
		index=i;
		setname(index);
		tempvalue=score;
		score=0;
		break;
		}
	}
	int temp=0;
            for(index;index<5;index++)
            { 
			   temp=Hscore[index];
		       Hscore[index]=tempvalue;
               tempvalue=temp;
			  
			  
			}
	FILE *fwrite;
    fwrite= (fopen("Newscore.txt", "w"));
    for(i=0;i<5;i++)
    {
        fprintf(fwrite,"%d ",Hscore[i]);
    }
    fclose(fwrite);

}

void setname(int nameindex)
{
	
	FILE*freadname;
	int i=0;

	freadname= (fopen("Name.txt", "r"));
    for(i=0;i<5;i++)
    {
       fscanf(freadname,"%s ",&str3[i]);

    }
    fclose(freadname);
	
	char strtemp[100];
			 for(nameindex;nameindex<5;nameindex++)
            { 
			   strcpy(strtemp,str3[nameindex]);
			   strcpy(str3[nameindex],str2);
		       strcpy(str2,strtemp);
			   printf("index2=%d",index);
              }
	
	FILE *fwrite2;
    fwrite2= (fopen("Name.txt", "w"));
    for(i=0;i<5;i++)
    {
        fprintf(fwrite2,"%s ",str3[i]);
    }
    fclose(fwrite2);
}


int readscr[5];
void Highscore()
{
	iShowBMP(0,0,hscore);
	iSetColor(106,47,106);
	iText(150,10,"press backspace to exit",GLUT_BITMAP_TIMES_ROMAN_24);
	int i;
	FILE *readscore,*readname;
	readscore=fopen("Newscore.txt","r");
	for(i=0;i<5;i++)
	{
		fscanf(readscore,"%d ",&readscr[i]);
	}

	readname = fopen("Name.txt", "r");
	    for(i=0;i<5;i++)
		{
		
		fscanf(readname, "%s ",&str4[i]);
		
		
		}

	fclose(readscore);
	fclose(readname);
	char s1[40],s2[40],s3[40],s4[40],s5[40];
	sprintf(s1,"%s %d \n",str4[0],readscr[0]);
	iSetColor(106,47,106);
	   iText(100,280, s1, GLUT_BITMAP_HELVETICA_18);
	sprintf(s2,"%s %d \n",str4[1],readscr[1]);
	iSetColor(106,47,106);
	   iText(100, 320, s2, GLUT_BITMAP_HELVETICA_18);
	sprintf(s3,"%s %d \n",str4[2],readscr[2]);
	iSetColor(106,47,106);
	   iText(100, 360, s3, GLUT_BITMAP_HELVETICA_18);
	sprintf(s4,"%s %d \n",str4[3],readscr[3]);
	 iSetColor(106,47,106);
	   iText(100, 400, s4, GLUT_BITMAP_HELVETICA_18);
	sprintf(s5,"%s %d \n",str4[4],readscr[4]);
	 iSetColor(106,47,106);
	   iText(100, 440, s5, GLUT_BITMAP_HELVETICA_18);

}

void Instruction()
{
	iShowBMP(0,0,instruction);
		iSetColor(0,0,0);
		iText(150,10,"press backspace to exit",GLUT_BITMAP_TIMES_ROMAN_24);
}

void SubMenu()
{
		iShowBMP(0,0,back);
		for (int i=0; i<3;i++)
	{
		iShowBMP2(subbutton[i].x,subbutton[i].y,subButton[i],0);
	} 
}

void GameOver()
{
	iShowBMP(0,0,gameover);
		iSetColor(255,255,255);
		iText(150,10,"press backspace to exit",GLUT_BITMAP_TIMES_ROMAN_24);
		setscore();
}


void iDraw()
	
{
	iClear();
	if(buttonIndex==-2)

	{
		iShowBMP(0,0,start);
	    backGroundShow();
	}
	else if(buttonIndex==-1)
	{
		Menu();
	}
	else if(buttonIndex==0)
	{
		
		Play();
	}
	else if(buttonIndex==1) 
	{
		
		 Highscore();
	}
	else if(buttonIndex==2)
	{
		Instruction();
		
	}
	else if(buttonIndex==3)
	{
		SubMenu();
	}
	if(gameOver)
	{
		GameOver();
	}

	
}



void iMouseMove(int mx, int my)
{
	//place your codes here
}



void iMouse(int button, int state, int mx, int my)
{

	
	if(button == GLUT_LEFT_BUTTON && state == GLUT_DOWN)
	{
		if(mx >= 150 && mx <= 400 && my >= 100 && my <= 280 && mode == 0)
		{
			mode = 1;
		}
		display(mx,my);
		disapear(mx,my);
		
	}
	if(button == GLUT_RIGHT_BUTTON && state == GLUT_DOWN)
	{
		//place your codes here	
	}
}


void iPassiveMouseMove(int mx,int my)
{
	//place your code here
	
 if(mx== 2){}        /*Something to do with mx*/
 else if(my== 2){}   /*Something to do with my*/
 
}


void iKeyboard(unsigned char key)
{
	
	if(buttonIndex==0)
	{
		if(key == '\b')
		{
			iPauseTimer(0);
			iPauseTimer(1);
			iPauseTimer(2);
			iPauseTimer(3);
			iPauseTimer(4);
		    buttonIndex=3;
		}
	}

    else if(buttonIndex==1 || buttonIndex==2 || gameOver)
	{
	 if(key == '\b')
	 {
		buttonIndex=-1;
		gameOver=false;
	 }

	}
	else if(buttonIndex==-2)
	{
		int i;
	if(mode == 1)
	{
		if(key == '\r')
		{
			buttonIndex=-1;
			
			mode= 0;
			strcpy(str2, str);
			printf("%s\n", str2);
			for(i = 0; i < len; i++)
				str[i] = 0;
			len = 0;
		}
		else
		{
			if(key=='\b'){
				str[--len]='\0';
				
			}
			else
			{
			str[len] = key;
			len++;
			}
		}
	}

	
	}
	
	 
}
	
	
	//place your codes for other keys here



void iSpecialKeyboard(unsigned char key)
{

	if(key == GLUT_KEY_LEFT)
	{
		
	}
}
//
void display(int a, int b)
{
	if(buttonIndex==-1)
	{
	
		for(int i=0; i<3; i++)
		{
			if(a>= mainbutton[i].x && a<= mainbutton[i].x+150 && b>=mainbutton[i].y && b<= mainbutton[i].y+150)
			{
				buttonIndex=i;
			
			}
		}
	}

	if(buttonIndex==3)
	{
	
		for(int i=0; i<3; i++)
		{
			if(a>= subbutton[i].x && a<= subbutton[i].x+150 && b>=subbutton[i].y && b<= subbutton[i].y+150)
			{
				if(i==0)
				{
					buttonIndex=0;
					iResumeTimer(0);
					iResumeTimer(1);
					iResumeTimer(2);
					iResumeTimer(3);
					iResumeTimer(4);
				}
				else if(i==1)
				{
					buttonIndex=0;
					pixieSet();
					score=0;
					life=3;
					iResumeTimer(0);
					iResumeTimer(1);
					iResumeTimer(2);
					iResumeTimer(3);
					iResumeTimer(4);
					
				}
				else if(i==2)
				{
					buttonIndex=-1;
				    pixieSet();
				}
			}
		}
	}
	
		
}

void disapear(int a, int b)
{		
	for(int i=0;i<evilPixie;i++)
	{
		if(a>= ePixie[i].x && a<=ePixie[i].x+100 && b>=ePixie[i].y && b<=ePixie[i].y+100)
		{
			ePixie[i].disapear=true;
			score++;
				
		}
	}

	
		
		if(a>= bPixie[0].x && a<=bPixie[0].x+200 && b>=bPixie[0].y && b<=bPixie[0].y+200)
		    {
				bigPixieLife--;
				if(bigPixieLife<=0)
				{
					score+=3;
					bPixie[0].disapear=true;
					bigPixieLife=3;
				}
			}
		
	


	for(int i=0;i<goodPixie;i++)
	{
		if(a>= gPixie[i].x && a<=gPixie[i].x+100 && b>=gPixie[i].y && b<=gPixie[i].y+100)
		{
			gPixie[i].disapear=true;
				
		}
	}


	for(int i=0;i<COIN;i++)
	{
		if(a>= coin[i].x && a<=coin[i].x+80 && b>=coin[i].y && b<=coin[i].y+80)
		{
			coin[i].disapear=true;
			score++;
				
		}
	}

	for(int i=0;i<LIFE1;i++)
	{
		if(a>= life1[i].x && a<=life1[i].x+80 && b>=life1[i].y && b<=life1[i].y+80)
		{
			life1[i].disapear=true;
			life++;
				
		}
	}

	
}
void pixieSet()
{
	for(int i=0;i<evilPixie;i++)
	{
		ePixie[i].x=rand()%300;
		ePixie[i].y=600+rand()%600;
		ePixie[i].disapear=false;
		ePixie[i].speed = 5;
	}

	for(int i=0;i<goodPixie;i++)
	{
		gPixie[i].x=rand()%300;
		gPixie[i].y=1000+rand()%600;
		gPixie[i].disapear=false;
		gPixie[i].speed = 5;
	}

	bigPixieLife=3;
	for(int i=0;i<bigPixie;i++)
	{
		bPixie[i].x=rand()%300;
		bPixie[i].y=1500+rand()%600;
		bPixie[i].disapear=false;
		bPixie[i].speed = 5;
	}


	for(int i=0;i<COIN;i++)
	{
		coin[i].x=rand()%300;
		coin[i].y=2000+rand()%600;
		coin[i].disapear=false;
		coin[i].speed = 5;
	}

	for(int i=0;i<LIFE1;i++)
	{
		life1[i].x=rand()%300;
		life1[i].y=2000+rand()%600;
		life1[i].disapear=false;
		life1[i].speed = 5;
	}
}

void mainbuttonSet()
{
	int sum=80;
	for(int i=2;i>=0;i--)
	{
		mainbutton[i].x=80;
		mainbutton[i].y=sum;
		sum+=130;
	}
}

void subbuttonSet()
{
	int sum1=80;
	for(int i=2;i>=0;i--)
	{
		subbutton[i].x=80;
		subbutton[i].y=sum1;
		sum1+=130;
	}
}

int main()
{
	len=0;
	mode=0;
	str[0]= 0;
	mainbuttonSet();
	subbuttonSet();
	pixieSet();
	iSetTimer(50,ePixieMove);
	iSetTimer(70,bPixieMove);
	iSetTimer(100,gPixieMove);
	iSetTimer(40,coinMove);
	iSetTimer(40,lifeMove);
	if(musicOn)
		PlaySound("music\\music.wav",NULL,SND_LOOP|SND_ASYNC);
	iInitialize(600, 600, "Pixie Smasher");
	return 0;
}