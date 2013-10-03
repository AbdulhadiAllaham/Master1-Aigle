using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using RemotingAdministrator;

namespace AdministratorForm
{
    public partial class Form2 : Form
    {
        Administrator admin = new Administrator("tcp://localhost:8089/Biblio");

        public Form2()
        {
            InitializeComponent();
            tabAbonneConnecte.Visible = false;
            buttonDeconnexion.Visible = false;
            
        }


        private void button1_Click(object sender, EventArgs e)
        {
            if (admin.EstConnecte())
            {
               // admin.Deconnexion();

                tabControl1.Visible = false;
                return;

            }
            if (textBox1.Text.Length == 0 || textBox2.Text.Length == 0)
            {
                MessageBox.Show("Les shamps pseudo et Mot de passe sont obligatoire");
                return;
            }

            if (admin.Connexion(textBox1.Text, textBox2.Text))
            {
                //MessageBox.Show("Connexion OK");
                tabControl1.Visible = false;
               
                tabControl1.Visible = false;
                tabAbonneConnecte.Visible = true;
                buttonDeconnexion.Visible = true;
                textBox1.Text = "";
                textBox2.Text = "";
            }
            else
            {
                MessageBox.Show("Pseudo ou Mot de passe Erroné");
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (admin.EstConnecte())
            {
                if (textNomAbonne.Text.Length == 0 || textNomAbonne.Text.Length == 0)
                {
                    MessageBox.Show("Les shamps pseudo et Mot de passe sont obligatoire");
                    return;
                }

                String add = admin.AddAbonne(textNomAbonne.Text, textPswAbone.Text);
                if (add.Length > 0)
                {
                    MessageBox.Show(add);
                    textNomAbonne.Text = "";
                    textPswAbone.Text = "";

                }
                else
                {
                    MessageBox.Show("Ajout pas ok");
                }



            }
        }

        private void bouttonAddLIvre_Click(object sender, EventArgs e)
        {

            if (admin.EstConnecte())
            {
                if(textBoxAuteur.Text.Length == 0 || textBoxTitre.Text.Length == 0 || textBoxEditeur.Text.Length == 0 || textBoxExemplaire.Text.Length == 0 || textBoxIsbn.Text.Length == 0)
                {
                    MessageBox.Show("Tous les champs sont obligatoires");
                    return;
                }

                String addlivre = admin.Createlivre(textBoxAuteur.Text,textBoxTitre.Text,textBoxIsbn.Text,textBoxEditeur.Text,textBoxExemplaire.Text);
                if (addlivre.Length > 0)
                {
                    MessageBox.Show(addlivre);
                    textBoxAuteur.Text = "";
                    textBoxTitre.Text = "";
                    textBoxIsbn.Text = "";
                    textBoxEditeur.Text = "";
                    textBoxExemplaire.Text = "";
                    return;
                }

            }

        }

        private void buttonDeconnexion_Click(object sender, EventArgs e)
        {
            buttonDeconnexion.Visible = false;
            admin.Deconnexion();
            tabControl1.Visible = true;
            tabAbonneConnecte.Visible = false;
           
        }

        private void textBoxEditeur_TextChanged(object sender, EventArgs e)
        {

        }

        

       
      

    
      

       

        
    }
}
