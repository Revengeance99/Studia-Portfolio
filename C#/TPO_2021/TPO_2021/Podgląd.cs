using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TPO_2021
{
    public partial class Podgląd : Form
    {
        Bitmap bmp;
        float x1=-1, y1=-1, x2=-1, y2=-1;

        Pen p = new Pen(Color.Red, 6);
        Graphics g;

        public float X1
        {
            set
            {
                x1 = value;
                odśwież_ramkę();
            }
        }

        public float Y1
        {
            set { y1 = value;
                odśwież_ramkę();
            }
        }

     public float X2 { set => x2 = value; }
     public float Y2 { set => y2 = value; }

        public Podgląd(Bitmap bmp)
        {
          InitializeComponent();
            this.bmp = bmp;
            
                pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.Image = bmp;

        }
        public void OdświeżPodgląd(Bitmap bitmap)
        {
            bmp = bitmap;
            pictureBox1.Image = bmp;
            pictureBox1.Refresh();
            odśwież_ramkę();
        }
       public void odśwież_ramkę()
        {
            while ((float)pictureBox1.ClientSize.Width / (float)pictureBox1.ClientSize.Height > (float)bmp.Width / (float)bmp.Height)
                this.Width--;
            while ((float)pictureBox1.ClientSize.Width / (float)pictureBox1.ClientSize.Height < (float)bmp.Width / (float)bmp.Height)
                this.Width++;

            if (x1 == -1 || x2 == -1 || y1 == -1 || y2 == -1)
                return;

            pictureBox1.Refresh();
            g = pictureBox1.CreateGraphics();
            g.DrawRectangle(p, new Rectangle(
                (int)(x1*(float)pictureBox1.Width), 
                (int)(y1* (float)pictureBox1.Height), 
                (int)(x2 * pictureBox1.Width), 
                (int)(y2 * pictureBox1.Height)
                ));

        }
        private void Podgląd_Load(object sender, EventArgs e)
        {

        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }
    }
}
