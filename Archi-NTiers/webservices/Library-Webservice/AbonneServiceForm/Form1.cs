using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

using RemotingInterfaces;

namespace AbonneServiceForm
{
    public partial class Form1 : Form
    {

        AbonneServiceForm.localhost.Service abonne = new AbonneServiceForm.localhost.Service();
        ISBNService.ISBNService ISBNServiceWeb = new ISBNService.ISBNService();       
        String nomUtuil;
        String passw;

        

        public Form1()
        {
            InitializeComponent();
            listView1.Visible = false;
            buttonDeconnexion.Visible = false;
            tabConnecte.Visible = false;
            listView1.Visible = false;
            listView2.Visible = false;
            label9.Visible = false;
           

        }

        private void buttonRechercheAuteur_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();
            String[] listelivre;
            listelivre = abonne.RechercheParAteur(textRechercheAuteur.Text);
            
            List<ListViewItem> listitem = new List<ListViewItem>();
            List<String> titres = new List<string>();
            foreach (String titre in listelivre)
            {
                this.Width = 870;
                listView1.Visible = true;
                ListViewItem item = new ListViewItem(titre);
                // Set to details view.
                
                listView1.View = View.Details;
                listView1.Items.Add(item);
                listView1.Visible = true;
                

            }
            if (listelivre.Length == 0)
                
            {
                this.Width = 480;
                listView1.Visible = false;
                MessageBox.Show("Aucun résultat trouvé");
            }

            textRechercheAuteur.Text = "";


            return;
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void buttonRechercheISBN_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();

            String livre="";
            
            livre = abonne.RechercheParISBN(textRehercheISBN.Text);
            if (livre != "Erreur")
            {
                this.Width = 870;
                ListViewItem item = new ListViewItem(livre);
                // Set to details view.

                listView1.View = View.Details;
                listView1.Items.Add(item);
                listView1.Visible = true;
            }
            else
            {
                this.Width = 480;
                listView1.Visible = false;
                MessageBox.Show("Aucun résultat trouvé");
            }

            textRehercheISBN.Text = "";
            
        }

        private void buttonConnexion_Click(object sender, EventArgs e)
        {

            FormConnexion form = new FormConnexion(this);
            form.Show(this);
        

        }

        public void accesfromotherform(String nomUt, String psw)
        {

            if (abonne.TestDeConnexion(nomUt, psw))
            {
                label9.Visible = true;
                label9.Text = "Bonjour " + nomUt;
                buttonConnexion.Visible = false;
                buttonDeconnexion.Visible = true;
                tabAbonne.Visible = false;
                tabConnecte.Visible = true;
                this.nomUtuil = nomUt;
                this.passw = psw;
            }
            
        }

        private void label3_Click(object sender, EventArgs e)
        {
           
        }

        private void button3_Click(object sender, EventArgs e)
        {
           

                if (textBoxISBN.Text.Length == 0 || textBoxCommenaire.Text.Length == 0)
                {
                    MessageBox.Show("Tous les champs sont obligatoire");
                    return;
                }


                String ajout = abonne.AjoutCommentaire(nomUtuil, passw, textBoxISBN.Text, textBoxCommenaire.Text);
                if (ajout.Length > 0)
                {
                    MessageBox.Show(ajout);
                    textBoxISBN.Text = "";
                    textBoxCommenaire.Text = "";
                }

            
        }

        private void buttonDeconnexion_Click(object sender, EventArgs e)
        {
            
            buttonDeconnexion.Visible = false;
            buttonConnexion.Visible = true;
            tabAbonne.Visible = true;
            tabConnecte.Visible = false;
            this.Width = 480;
            listView1.Visible = false;
            label9.Visible = false;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();
            String[] listelivre;
            listelivre = abonne.RechercheParAteur(textBoxAuteur.Text);


            List<ListViewItem> listitem = new List<ListViewItem>();
            List<String> titres = new List<string>();
            foreach (String livre in listelivre)
            {
                this.Width = 870;  
                ListViewItem item = new ListViewItem(livre);
                // Set to details view.

                listView1.View = View.Details;
                listView1.Items.Add(item);
                listView1.Visible = true;
            }
            if (listelivre.Length == 0)
            {
                this.Width = 480;
                listView1.Visible = false;
                MessageBox.Show("Aucun résultat trouvé");
            }
            textBoxAuteur.Text = "";

        }

        private void button1_Click(object sender, EventArgs e)
        {
            listView1.Items.Clear();

            String livre;

            livre = abonne.RechercheParISBN(textBoxISBN2.Text);
            if (livre != "Erreur")
            {
                this.Width = 870;
                ListViewItem item = new ListViewItem(livre);
                // Set to details view.

                listView1.View = View.Details;
                listView1.Items.Add(item);
                listView1.Visible = true;
            }
            else
            {
                this.Width = 480;
                listView1.Visible = false;
                MessageBox.Show("Aucun résultat trouvé");
            }
            textBoxISBN2.Text = "";
        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void buttonConsultComment_Click(object sender, EventArgs e)
        {
            listView2.Items.Clear();

           
            String[] listcomments;
            listcomments = abonne.RecupCommentaire(textBoxISBNCommenaire.Text);
            

           // livre = abonne.RechercheParISBN(textBoxISBNCommenaire.Text);

            if (listcomments != null)
            {
             
                //listcomment=livre.Commentaires;

                foreach (String comment in listcomments)
                {
                    ListViewItem item = new ListViewItem(comment);
                    
                listView2.View = View.Details;
                listView2.Items.Add(item);
                listView2.Visible = true;

                }
                
                // Set to details view.

            }
            else
            {
                MessageBox.Show("Aucun résultat trouvé");
            }
            textBoxISBNCommenaire.Text = "";


        }

        private void buttonVerifISBN_Click(object sender, EventArgs e)
        {
            if (textBoxISBNCommenaire.Text.Length != 13 && textBoxISBNCommenaire.Text.Length != 10)
            {
                MessageBox.Show("L'ISBN doit comporter 10 ou 13 lettres");
                return;
            }

            bool result = false;
            bool result2 = false;

            if (textBoxISBNCommenaire.Text.Length == 13)
            {
                result = ISBNServiceWeb.IsValidISBN13(textBoxISBNCommenaire.Text);
            }

            if (textBoxISBNCommenaire.Text.Length == 10)
            {
                result2 = ISBNServiceWeb.IsValidISBN10(textBoxISBNCommenaire.Text);
            }

            if (result)
            {
                MessageBox.Show("L'ISBN13 a été vérifié avec succès");
            }
            else if (result2)
            {
                MessageBox.Show("L'ISBN10 a été vérifié avec succès");
            }
            else
            {
                MessageBox.Show("L'ISBN n'existe pas");
            }
        }
        

        

        
    }
}
