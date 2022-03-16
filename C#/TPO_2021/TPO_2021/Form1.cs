using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Imaging;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TPO_2021
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            openFileDialog1.Filter = filtr;
        }

        Bitmap bmp = null;
        List<Bitmap> undo = new List<Bitmap>();
        const string filtr = "Pliki BMP (*.bmp)|*.bmp|Pliki JPEG (*.jpg)|*.jpg|Wszystkie pliki (*.*)|*.*";

        void zapamiętaj_undo()
        {
            if (bmp == null)
                return;

            undo.Insert(0, new Bitmap(bmp));
            cofnijToolStripMenuItem.Enabled = true;


        }

        private void otwórzToolStripMenuItem_Click(object sender, EventArgs e)
        {
            openFileDialog1.ShowDialog();
            bmp = new Bitmap(openFileDialog1.FileName);
            pictureBox1.Image = bmp;
            pictureBox1.Size = bmp.Size;
        }

        private void zamknijToolStripMenuItem_Click(object sender, EventArgs e)
        {
            saveFileDialog1.Filter = openFileDialog1.Filter;
            if (saveFileDialog1.ShowDialog() != DialogResult.OK)
                return;
            if (saveFileDialog1.FileName.Substring(saveFileDialog1.FileName.Length - 4) == ".jpg")
                bmp.Save(saveFileDialog1.FileName, ImageFormat.Jpeg);
            else if (saveFileDialog1.FileName.Substring(saveFileDialog1.FileName.Length - 4) == ".bmp")
                bmp.Save(saveFileDialog1.FileName, ImageFormat.Bmp);
            else MessageBox.Show("Niestety nie obsługujemy tego formatu");
        }

        private void toolStripMenuItem2_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Normal;
            pictureBox1.Size = bmp.Size;
        }

        private void dopasujToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.Size = panel1.ClientSize;
        }

        private void toolStripMenuItem3_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.Size = new Size(bmp.Width / 2, bmp.Height / 2);
        }

        private void toolStripMenuItem4_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.Size = new Size(bmp.Width / 4, bmp.Height / 4);
        }

        private void toolStripMenuItem5_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.Size = new Size(bmp.Width / 8, bmp.Height / 8);
        }

        private void xToolStripMenuItem_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.Size = new Size(bmp.Width * 2, bmp.Height * 2);
        }

        private void xToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.Size = new Size(bmp.Width * 4, bmp.Height * 4);
        }

        private void xToolStripMenuItem2_Click(object sender, EventArgs e)
        {
            pictureBox1.SizeMode = PictureBoxSizeMode.Zoom;
            pictureBox1.Size = new Size(bmp.Width * 8, bmp.Height * 8);
        }

        private void przyciemnienieToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color color1 = bmp.GetPixel(x, y);
                    Color color2 = Color.FromArgb(color1.R / 2, color1.G / 2, color1.B / 2);
                    bmp.SetPixel(x, y, color2);
                }
            }
            progressBar1.Visible = false;
            Refresh();
        }

        private void rozjaśnienieToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color color1 = bmp.GetPixel(x, y);
                    Color color2 = Color.FromArgb(255 - (255 - color1.R) / 2, 255 - (255 - color1.G) / 2, 255 - (255 - color1.B) / 2);
                    bmp.SetPixel(x, y, color2);
                }
            }
            progressBar1.Visible = false;
            Refresh();
        }

        private void oziębienieToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color color1 = bmp.GetPixel(x, y);
                    Color color2 = Color.FromArgb(color1.R / 2, color1.G, 255 - (255 - color1.B) / 2);
                    bmp.SetPixel(x, y, color2);
                }
            }
            progressBar1.Visible = false;
            Refresh();
        }

        private void ocieplenieToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color color1 = bmp.GetPixel(x, y);
                    Color color2 = Color.FromArgb(255 - (255 - color1.R) / 2, color1.G, color1.B / 2);
                    bmp.SetPixel(x, y, color2);
                }
            }
            progressBar1.Visible = false;
            Refresh();
        }

        private void rozjaśnijŚciemnijToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            Parametr form = new Parametr();
            form.Text = "Rozjaśnij / ściemnij:";
            if (form.ShowDialog() != DialogResult.OK)
                return;
            int rozjŚciem = form.Value;

            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color c1 = bmp.GetPixel(x, y);
                    int r = c1.R, g = c1.G, b = c1.B;

                    r += rozjŚciem;
                    g += rozjŚciem;
                    b += rozjŚciem;

                    if (r < 0)
                        r = 0;
                    if (r > 255)
                        r = 255;

                    if (g < 0)
                        g = 0;
                    if (g > 255)
                        g = 255;

                    if (b < 0)
                        b = 0;
                    if (b > 255)
                        b = 255;

                    Color c2 = Color.FromArgb
                        (r, g, b);
                    bmp.SetPixel(x, y, c2);
                }
            }

            progressBar1.Visible = false;
            Refresh();
        }



        private void czarnoBiałeToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;
            int greyscale;
            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color c1 = bmp.GetPixel(x, y);
                    greyscale = (3 * c1.R + 6 * c1.G + c1.B) / 10;



                    Color c2 = Color.FromArgb
                        (greyscale, greyscale, greyscale);
                    bmp.SetPixel(x, y, c2);
                }
            }
            progressBar1.Visible = false;
            Refresh();
        }

        private void czerńBielToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;
            int greyscale;
            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color c1 = bmp.GetPixel(x, y);
                    greyscale = (3 * c1.R + 6 * c1.G + c1.B) / 10;
                    if (greyscale < 128)
                    {
                        greyscale = 0;
                    }
                    else
                    {
                        greyscale = 255;
                    }

                    Color c2 = Color.FromArgb
                        (greyscale, greyscale, greyscale);
                    bmp.SetPixel(x, y, c2);
                }
            }
            progressBar1.Visible = false;
            Refresh();
        }

        private void czerńBielErrToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;
            int greyscale;
            int err = 0;
            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color c1 = bmp.GetPixel(x, y);
                    greyscale = (3 * c1.R + 6 * c1.G + c1.B) / 10 + err;
                    if (greyscale < 128)
                    {
                        bmp.SetPixel(x, y, Color.Black);
                        err = greyscale;
                    }
                    else
                    {
                        bmp.SetPixel(x, y, Color.White);
                        err = greyscale - 255;
                    }

                }
            }
            progressBar1.Visible = false;
            Refresh();
        }

        private void czerńBielFloydToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            int[,] greyscale = new int[bmp.Width, bmp.Height];
            progressBar1.Visible = true;
            progressBar1.Maximum = 100;
            int err = 0;
            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y * 30 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color c1 = bmp.GetPixel(x, y);
                    greyscale[x, y] = (3 * c1.R + 6 * c1.G + c1.B) / 10 + err;


                }
            }

            Refresh();
            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = 30 + y * 70 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    if (greyscale[x, y] < 128)
                    {

                        bmp.SetPixel(x, y, Color.Black);
                        err = greyscale[x, y];
                    }
                    else
                    {
                        bmp.SetPixel(x, y, Color.White);
                        err = greyscale[x, y] - 255;
                    }

                    if (x < bmp.Width - 1)
                    {
                        greyscale[x + 1, y] += err * 7 / 16;

                    }
                    if (x > 0 && y < bmp.Height - 1)
                    {
                        greyscale[x - 1, y + 1] += err * 3 / 16;

                    }
                    if (x < bmp.Width - 1 && y < bmp.Height - 1)
                    {
                        greyscale[x + 1, y + 1] += err * 1 / 16;

                    }
                    if (y < bmp.Height - 1)
                    {
                        greyscale[x, y + 1] += err * 5 / 16;

                    }

                }
            }
            progressBar1.Visible = false;
            Refresh();

        }

        private void kolorJednolityToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            int[,,] rgb = new int[bmp.Width, bmp.Height, 3];
            progressBar1.Visible = true;
            progressBar1.Maximum = 100;
            int err = 0;
            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y * 30 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    Color c1 = bmp.GetPixel(x, y);
                    rgb[x, y, 0] = c1.R;
                    rgb[x, y, 1] = c1.G;
                    rgb[x, y, 2] = c1.B;


                }
            }

            int[] col = { 0, 0, 0 };
            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = 30 + y * 70 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        if (rgb[x, y, i] >= 128)
                        {
                            col[i] = 255;

                        }
                        else
                        {
                            col[i] = 0;

                        }
                    }
                    bmp.SetPixel(x, y, Color.FromArgb(col[0], col[1], col[2]));

                }
            }
            progressBar1.Visible = false;
            Refresh();

        }

        private void kolorFloydToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            int[,,] rgbArr = new int[bmp.Width, bmp.Height, 3];
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;
            int[] col = { 0, 0, 0 }, err = { 0, 0, 0 };
            Color c1;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y * 30 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    c1 = bmp.GetPixel(x, y);
                    rgbArr[x, y, 0] = c1.R;
                    rgbArr[x, y, 1] = c1.G;
                    rgbArr[x, y, 2] = c1.B;
                }
            }

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = 30 + y * 70 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        if (rgbArr[x, y, i] >= 128)
                        {
                            col[i] = 255;
                            err[i] = rgbArr[x, y, i] - 255;
                            // bmp.SetPixel(x, y, Color.);
                        }
                        else
                        {
                            col[i] = 0;
                            err[i] = rgbArr[x, y, i];
                            // bmp.SetPixel(x, y, Color.White);
                        }

                        if (x < bmp.Width - 1)
                        {
                            rgbArr[x + 1, y, i] += err[i] * 7 / 16;
                        }

                        if (x > 0 && y < bmp.Height - 1)
                        {
                            rgbArr[x - 1, y + 1, i] += err[i] * 3 / 16;
                        }

                        if (x < bmp.Width - 1 && y < bmp.Height - 1)
                        {
                            rgbArr[x, y + 1, i] += err[i] * 1 / 16;
                        }

                        if (y > bmp.Height - 1)
                        {
                            rgbArr[x + 1, y + 1, i] += err[i] * 5 / 16;

                        }

                        bmp.SetPixel(x, y, Color.FromArgb(col[0], col[1], col[2]));
                    }
                }
            }

            progressBar1.Visible = false;
            Refresh();
        }

        private void kolorówToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            int[,,] rgbArr = new int[bmp.Width, bmp.Height, 3];
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;
            int[] col = { 0, 0, 0 }, err = { 0, 0, 0 };
            Color c1;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y * 30 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    c1 = bmp.GetPixel(x, y);
                    rgbArr[x, y, 0] = c1.R;
                    rgbArr[x, y, 1] = c1.G;
                    rgbArr[x, y, 2] = c1.B;
                }
            }

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = 30 + y * 70 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        col[i] = (rgbArr[x, y, i] + 42) / 85;
                        err[i] = rgbArr[x, y, i] - col[i] * 85;


                        if (x < bmp.Width - 1)
                        {
                            rgbArr[x + 1, y, i] += err[i] * 7 / 16;
                        }

                        if (x > 0 && y < bmp.Height - 1)
                        {
                            rgbArr[x - 1, y + 1, i] += err[i] * 3 / 16;
                        }

                        if (x < bmp.Width - 1 && y < bmp.Height - 1)
                        {
                            rgbArr[x, y + 1, i] += err[i] * 1 / 16;
                        }

                        if (y > bmp.Height - 1)
                        {
                            rgbArr[x + 1, y + 1, i] += err[i] * 5 / 16;

                        }

                        bmp.SetPixel(x, y, Color.FromArgb(col[0] * 85, col[1] * 85, col[2] * 85));
                    }
                }
            }

            progressBar1.Visible = false;
            Refresh();
        }

        private void kolorówToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            int[,,] rgbArr = new int[bmp.Width, bmp.Height, 3];
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;
            int[] col = { 0, 0, 0 }, err = { 0, 0, 0 };
            Color c1;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y * 30 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    c1 = bmp.GetPixel(x, y);
                    rgbArr[x, y, 0] = c1.R;
                    rgbArr[x, y, 1] = c1.G;
                    rgbArr[x, y, 2] = c1.B;
                }
            }

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = 30 + y * 70 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    for (int i = 0; i < 3; i++)
                    {
                        col[i] = (rgbArr[x, y, i] + 18) / 36;
                        err[i] = rgbArr[x, y, i] - col[i] * 36;


                        if (x < bmp.Width - 1)
                        {
                            rgbArr[x + 1, y, i] += err[i] * 7 / 16;
                        }

                        if (x > 0 && y < bmp.Height - 1)
                        {
                            rgbArr[x - 1, y + 1, i] += err[i] * 3 / 16;
                        }

                        if (x < bmp.Width - 1 && y < bmp.Height - 1)
                        {
                            rgbArr[x, y + 1, i] += err[i] * 1 / 16;
                        }

                        if (y > bmp.Height - 1)
                        {
                            rgbArr[x + 1, y + 1, i] += err[i] * 5 / 16;

                        }

                        bmp.SetPixel(x, y, Color.FromArgb(col[0] * 36, col[1] * 36, col[2] * 36));
                    }
                }
            }

            progressBar1.Visible = false;
            Refresh();
        }

        private void cofnijToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (undo.Count == 0)
                return;
            bmp = undo[0];
            undo.RemoveAt(0);
            pictureBox1.Image = bmp;
            pictureBox1.Refresh();


            if (undo.Count == 0)
                cofnijToolStripMenuItem.Enabled = false;
            if (podgląd != null)
                podgląd.OdświeżPodgląd(bmp);

        }
        Podgląd podgląd = null;
        private void podglądToolStripMenuItem_Click(object sender, EventArgs e)
        {
            if (bmp == null)
                return;
            if (podgląd != null)
            {
                podgląd.Close();
                podgląd = null;
                return;
            }
            podgląd = new Podgląd(bmp);
            podgląd.Show();
            podgląd.Refresh();
        }

        private void pictureBox1_Paint(object sender, PaintEventArgs e)
        {
            if (podgląd == null)
                return;
            podgląd.X1 = (float)panel1.HorizontalScroll.Value / (float)pictureBox1.Width;
            podgląd.Y1 = (float)panel1.VerticalScroll.Value / (float)pictureBox1.Height;

            podgląd.X2 = (float)panel1.ClientSize.Width / (float)pictureBox1.Width;
            podgląd.Y2 = (float)panel1.ClientSize.Height / (float)pictureBox1.Height;


        }

        private void saveFileDialog1_FileOk(object sender, CancelEventArgs e)
        {

        }

        private void blurToolStripMenuItem_Click(object sender, EventArgs e)
        {
            zapamiętaj_undo();
            int[,,] rgb = new int[bmp.Width, bmp.Height, 3];
            progressBar1.Visible = true;
            progressBar1.Maximum = bmp.Height;
            int[] col = { 0, 0, 0 }, err = { 0, 0, 0 };
            Color c1;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = y * 30 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    c1 = bmp.GetPixel(x, y);
                    rgb[x, y, 0] = c1.R;
                    rgb[x, y, 1] = c1.G;
                    rgb[x, y, 2] = c1.B;
                }
            }

            int blur_level = 2;

            for (int y = 0; y < bmp.Height; y++)
            {
                progressBar1.Value = 30 + y * 40 / bmp.Height;
                for (int x = 0; x < bmp.Width; x++)
                {
                    int suma_sąsiadów = new int[] { 0, 0, 0 };
                    int ilu_sąsiadów = 0;
                    for (int y1 = y - blur_level; y1 <= y + blur_level; y1++)
                    {
                        for (int x1 = x - blur_level; x1 <= x + blur_level; x1++)
                        {
                            if (x1 < 0 || x1 >= rgb.GetLength(0) || y1 < 0
                            continue;
                            
                            for(int s = 0; s < 3; s++)
                            {
                                suma_sąsiadów[s] += rgb[x1, y1, s];
                            }
                            ilu_sąsiadów++;
                        }
                    }
                    for (int s = 0; s < 3; s++;){
                    fin_rgb[x, y, s];
                     }
                    progressBar1.Visible = false;
                    Refresh();
                }
            }
        }
    }
}


