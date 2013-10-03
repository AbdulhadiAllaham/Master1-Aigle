using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using RemotingAbonne;
using RemotingInterfaces;

namespace AbonneServiceForm
{
    public partial class Form1 : Form
    {

        Abonne abonne = new Abonne("tcp://localhost:8089/Biblio");
        
        

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
            List<ILivre> listelivre = new List<ILivre>();
            listelivre = abonne.RechercheparAteur(textRechercheAuteur.Text);
            
            List<ListViewItem> listitem = new List<ListViewItem>();
            List<String> titres = new List<string>();
            foreach (ILivre livre in listelivre)
            {
                this.Width = 870;
                listView1.Visible = true;
                 ListViewItem item = new ListViewItem(new[] {livre.Auteur,livre.Titre,livre.Isbn,livre.NombreExamplaire});
                // Set to details view.
                
                listView1.View = View.Details;
                listView1.Items.Add(item);
                listView1.Visible = true;
                

            }
            if (listelivre.Count == 0)
                
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

            ILivre livre;
            
            livre = abonne.RecherparISBN(textRehercheISBN.Text);
            if (livre != null)
            {
                this.Width = 870;
                ListViewItem item = new ListViewItem(new[] { livre.Auteur, livre.Titre, livre.Isbn, livre.NombreExamplaire });
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

            if (abonne.Connexion(nomUt, psw))
            {
                label9.Visible = true;
                label9.Text = "Bonjour " + nomUt;
                buttonConnexion.Visible = false;
                buttonDeconnexion.Visible = true;
                tabAbonne.Visible = false;
                tabConnecte.Visible = true;
            }
            
        }

        private void label3_Click(object sender, EventArgs e)
        {
           
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (abonne.EstConnecte())
            {

                if (textBoxISBN.Text.Length == 0 || textBoxCommenaire.Text.Length == 0)
                {
                    MessageBox.Show("Tous les champs sont obligatoire");
                    return;
                }


                String ajout = abonne.AjoutCommentaire(textBoxISBN.Text, textBoxCommenaire.Text);
                if (ajout.Length > 0)
                {
                    MessageBox.Show(ajout);
                    textBoxISBN.Text = "";
                    textBoxCommenaire.Text = "";
                }

            }
        }

        private void buttonDeconnexion_Click(object sender, EventArgs e)
        {
            abonne.Deconnexion();
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
            List<ILivre> listelivre = new List<ILivre>();
            listelivre = abonne.RechercheparAteur(textBoxAuteur.Text);


            List<ListViewItem> listitem = new List<ListViewItem>();
            List<String> titres = new List<string>();
            foreach (ILivre livre in listelivre)
            {
                this.Width = 870;  
                ListViewItem item = new ListViewItem(new[] { livre.Auteur, livre.Titre, livre.Isbn, livre.NombreExamplaire });
                // Set to details view.

                listView1.View = View.Details;
                listView1.Items.Add(item);
                listView1.Visible = true;
            }
            if (listelivre.Count == 0)
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

            ILivre livre;

            livre = abonne.RecherparISBN(textBoxISBN2.Text);
            if (livre != null)
            {
                this.Width = 870;
                ListViewItem item = new ListViewItem(new[] { livre.Auteur, livre.Titre, livre.Isbn, livre.NombreExamplaire });
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

            ILivre livre;

            livre = abonne.RecherparISBN(textBoxISBNCommenaire.Text);

            if (livre != null)
            
            {
             List<String> listcomment = new List<string>(); 
                listcomment=livre.Commentaires;

                foreach(String comment  in listcomment){
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

        

        
    }
}
