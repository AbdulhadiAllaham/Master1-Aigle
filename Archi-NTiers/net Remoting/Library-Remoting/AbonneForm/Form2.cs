using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace AbonneForm
{
    public partial class FormConnexion : Form
    {

       

        public FormConnexion(Form1 form1)
        {
            InitializeComponent();
            this.form1 = form1;
        }

        public Form1 form1;

        private void buttonConnexion_Click(object sender, EventArgs e)
        {
         //   MessageBox.Show(textBoxNomUtilisateur.Text + textBoxPSW.Text);
     
            form1.accesfromotherform(textBoxNomUtilisateur.Text,textBoxPSW.Text);
            this.Close();

        }
    }
}
