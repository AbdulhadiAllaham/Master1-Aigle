namespace AbonneServiceForm
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.tabAbonne = new System.Windows.Forms.TabControl();
            this.tabRecherche = new System.Windows.Forms.TabPage();
            this.buttonRechercheISBN = new System.Windows.Forms.Button();
            this.buttonRechercheAuteur = new System.Windows.Forms.Button();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.textRehercheISBN = new System.Windows.Forms.TextBox();
            this.textRechercheAuteur = new System.Windows.Forms.TextBox();
            this.buttonConnexion = new System.Windows.Forms.Button();
            this.listView1 = new System.Windows.Forms.ListView();
            this.Auteur = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Titre = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.ISBN = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Exemplaires = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.buttonDeconnexion = new System.Windows.Forms.Button();
            this.tabConnecte = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.textBoxISBN2 = new System.Windows.Forms.TextBox();
            this.textBoxAuteur = new System.Windows.Forms.TextBox();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.textBoxCommenaire = new System.Windows.Forms.TextBox();
            this.textBoxISBN = new System.Windows.Forms.TextBox();
            this.button3 = new System.Windows.Forms.Button();
            this.tabPage3 = new System.Windows.Forms.TabPage();
            this.listView2 = new System.Windows.Forms.ListView();
            this.columnCommentaire = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.buttonConsultComment = new System.Windows.Forms.Button();
            this.label7 = new System.Windows.Forms.Label();
            this.textBoxISBNCommenaire = new System.Windows.Forms.TextBox();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.tabAbonne.SuspendLayout();
            this.tabRecherche.SuspendLayout();
            this.tabConnecte.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.tabPage3.SuspendLayout();
            this.SuspendLayout();
            // 
            // tabAbonne
            // 
            this.tabAbonne.Controls.Add(this.tabRecherche);
            this.tabAbonne.Location = new System.Drawing.Point(38, 40);
            this.tabAbonne.Name = "tabAbonne";
            this.tabAbonne.SelectedIndex = 0;
            this.tabAbonne.Size = new System.Drawing.Size(392, 237);
            this.tabAbonne.TabIndex = 0;
            // 
            // tabRecherche
            // 
            this.tabRecherche.Controls.Add(this.buttonRechercheISBN);
            this.tabRecherche.Controls.Add(this.buttonRechercheAuteur);
            this.tabRecherche.Controls.Add(this.label2);
            this.tabRecherche.Controls.Add(this.label1);
            this.tabRecherche.Controls.Add(this.textRehercheISBN);
            this.tabRecherche.Controls.Add(this.textRechercheAuteur);
            this.tabRecherche.Location = new System.Drawing.Point(4, 22);
            this.tabRecherche.Name = "tabRecherche";
            this.tabRecherche.Padding = new System.Windows.Forms.Padding(3);
            this.tabRecherche.Size = new System.Drawing.Size(384, 211);
            this.tabRecherche.TabIndex = 0;
            this.tabRecherche.Text = "Rechercher ouvrage";
            this.tabRecherche.UseVisualStyleBackColor = true;
            // 
            // buttonRechercheISBN
            // 
            this.buttonRechercheISBN.Location = new System.Drawing.Point(249, 169);
            this.buttonRechercheISBN.Name = "buttonRechercheISBN";
            this.buttonRechercheISBN.Size = new System.Drawing.Size(100, 23);
            this.buttonRechercheISBN.TabIndex = 5;
            this.buttonRechercheISBN.Text = "Rechercher";
            this.buttonRechercheISBN.UseVisualStyleBackColor = true;
            this.buttonRechercheISBN.Click += new System.EventHandler(this.buttonRechercheISBN_Click);
            // 
            // buttonRechercheAuteur
            // 
            this.buttonRechercheAuteur.Location = new System.Drawing.Point(249, 77);
            this.buttonRechercheAuteur.Name = "buttonRechercheAuteur";
            this.buttonRechercheAuteur.Size = new System.Drawing.Size(100, 23);
            this.buttonRechercheAuteur.TabIndex = 4;
            this.buttonRechercheAuteur.Text = "Rechercher";
            this.buttonRechercheAuteur.UseVisualStyleBackColor = true;
            this.buttonRechercheAuteur.Click += new System.EventHandler(this.buttonRechercheAuteur_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(51, 130);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(106, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Recherche par ISBN";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(46, 35);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(111, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Recherche par auteur";
            // 
            // textRehercheISBN
            // 
            this.textRehercheISBN.Location = new System.Drawing.Point(249, 127);
            this.textRehercheISBN.Name = "textRehercheISBN";
            this.textRehercheISBN.Size = new System.Drawing.Size(100, 20);
            this.textRehercheISBN.TabIndex = 1;
            // 
            // textRechercheAuteur
            // 
            this.textRechercheAuteur.Location = new System.Drawing.Point(249, 35);
            this.textRechercheAuteur.Name = "textRechercheAuteur";
            this.textRechercheAuteur.Size = new System.Drawing.Size(100, 20);
            this.textRechercheAuteur.TabIndex = 0;
            // 
            // buttonConnexion
            // 
            this.buttonConnexion.Location = new System.Drawing.Point(182, 303);
            this.buttonConnexion.Name = "buttonConnexion";
            this.buttonConnexion.Size = new System.Drawing.Size(96, 23);
            this.buttonConnexion.TabIndex = 1;
            this.buttonConnexion.Text = "Se connecter";
            this.buttonConnexion.UseVisualStyleBackColor = true;
            this.buttonConnexion.Click += new System.EventHandler(this.buttonConnexion_Click);
            // 
            // listView1
            // 
            this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.Auteur,
            this.Titre,
            this.ISBN,
            this.Exemplaires});
            this.listView1.Location = new System.Drawing.Point(487, 62);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(341, 211);
            this.listView1.TabIndex = 2;
            this.listView1.UseCompatibleStateImageBehavior = false;
            // 
            // Auteur
            // 
            this.Auteur.Text = "Auteur";
            // 
            // Titre
            // 
            this.Titre.Text = "Titre";
            this.Titre.Width = 100;
            // 
            // ISBN
            // 
            this.ISBN.Text = "ISBN";
            // 
            // Exemplaires
            // 
            this.Exemplaires.Text = "Exemplaires";
            this.Exemplaires.Width = 100;
            // 
            // buttonDeconnexion
            // 
            this.buttonDeconnexion.Location = new System.Drawing.Point(182, 303);
            this.buttonDeconnexion.Name = "buttonDeconnexion";
            this.buttonDeconnexion.Size = new System.Drawing.Size(96, 23);
            this.buttonDeconnexion.TabIndex = 3;
            this.buttonDeconnexion.Text = "Déconnexion";
            this.buttonDeconnexion.UseVisualStyleBackColor = true;
            this.buttonDeconnexion.Click += new System.EventHandler(this.buttonDeconnexion_Click);
            // 
            // tabConnecte
            // 
            this.tabConnecte.Controls.Add(this.tabPage1);
            this.tabConnecte.Controls.Add(this.tabPage2);
            this.tabConnecte.Controls.Add(this.tabPage3);
            this.tabConnecte.Location = new System.Drawing.Point(38, 40);
            this.tabConnecte.Name = "tabConnecte";
            this.tabConnecte.SelectedIndex = 0;
            this.tabConnecte.Size = new System.Drawing.Size(392, 237);
            this.tabConnecte.TabIndex = 4;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.button1);
            this.tabPage1.Controls.Add(this.button2);
            this.tabPage1.Controls.Add(this.label3);
            this.tabPage1.Controls.Add(this.label4);
            this.tabPage1.Controls.Add(this.textBoxISBN2);
            this.tabPage1.Controls.Add(this.textBoxAuteur);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(384, 211);
            this.tabPage1.TabIndex = 1;
            this.tabPage1.Text = "Rechercher ouvrage";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(249, 169);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(100, 23);
            this.button1.TabIndex = 5;
            this.button1.Text = "Rechercher";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(249, 77);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(100, 23);
            this.button2.TabIndex = 4;
            this.button2.Text = "Rechercher";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(46, 130);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(106, 13);
            this.label3.TabIndex = 3;
            this.label3.Text = "Recherche par ISBN";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(46, 35);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(111, 13);
            this.label4.TabIndex = 2;
            this.label4.Text = "Recherche par auteur";
            // 
            // textBoxISBN2
            // 
            this.textBoxISBN2.Location = new System.Drawing.Point(185, 127);
            this.textBoxISBN2.Name = "textBoxISBN2";
            this.textBoxISBN2.Size = new System.Drawing.Size(164, 20);
            this.textBoxISBN2.TabIndex = 1;
            // 
            // textBoxAuteur
            // 
            this.textBoxAuteur.Location = new System.Drawing.Point(185, 35);
            this.textBoxAuteur.Name = "textBoxAuteur";
            this.textBoxAuteur.Size = new System.Drawing.Size(164, 20);
            this.textBoxAuteur.TabIndex = 0;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.label6);
            this.tabPage2.Controls.Add(this.label5);
            this.tabPage2.Controls.Add(this.textBoxCommenaire);
            this.tabPage2.Controls.Add(this.textBoxISBN);
            this.tabPage2.Controls.Add(this.button3);
            this.tabPage2.Location = new System.Drawing.Point(4, 22);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(384, 211);
            this.tabPage2.TabIndex = 2;
            this.tabPage2.Text = "Ajouter Commenaitre";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(41, 59);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(68, 13);
            this.label6.TabIndex = 4;
            this.label6.Text = "Commentaire";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(38, 17);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(32, 13);
            this.label5.TabIndex = 3;
            this.label5.Text = "ISBN";
            // 
            // textBoxCommenaire
            // 
            this.textBoxCommenaire.Location = new System.Drawing.Point(37, 78);
            this.textBoxCommenaire.Multiline = true;
            this.textBoxCommenaire.Name = "textBoxCommenaire";
            this.textBoxCommenaire.Size = new System.Drawing.Size(299, 85);
            this.textBoxCommenaire.TabIndex = 2;
            // 
            // textBoxISBN
            // 
            this.textBoxISBN.Location = new System.Drawing.Point(37, 31);
            this.textBoxISBN.Name = "textBoxISBN";
            this.textBoxISBN.Size = new System.Drawing.Size(300, 20);
            this.textBoxISBN.TabIndex = 1;
            // 
            // button3
            // 
            this.button3.Location = new System.Drawing.Point(113, 169);
            this.button3.Name = "button3";
            this.button3.Size = new System.Drawing.Size(112, 23);
            this.button3.TabIndex = 0;
            this.button3.Text = "Ajouter commenaitre";
            this.button3.UseVisualStyleBackColor = true;
            this.button3.Click += new System.EventHandler(this.button3_Click);
            // 
            // tabPage3
            // 
            this.tabPage3.Controls.Add(this.listView2);
            this.tabPage3.Controls.Add(this.buttonConsultComment);
            this.tabPage3.Controls.Add(this.label7);
            this.tabPage3.Controls.Add(this.textBoxISBNCommenaire);
            this.tabPage3.Location = new System.Drawing.Point(4, 22);
            this.tabPage3.Name = "tabPage3";
            this.tabPage3.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage3.Size = new System.Drawing.Size(384, 211);
            this.tabPage3.TabIndex = 3;
            this.tabPage3.Text = "Visualiser commentaires";
            this.tabPage3.UseVisualStyleBackColor = true;
            // 
            // listView2
            // 
            this.listView2.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnCommentaire});
            this.listView2.Location = new System.Drawing.Point(20, 77);
            this.listView2.Name = "listView2";
            this.listView2.Size = new System.Drawing.Size(329, 97);
            this.listView2.TabIndex = 3;
            this.listView2.UseCompatibleStateImageBehavior = false;
            // 
            // columnCommentaire
            // 
            this.columnCommentaire.Text = "Commentaire";
            this.columnCommentaire.Width = 300;
            // 
            // buttonConsultComment
            // 
            this.buttonConsultComment.Location = new System.Drawing.Point(184, 35);
            this.buttonConsultComment.Name = "buttonConsultComment";
            this.buttonConsultComment.Size = new System.Drawing.Size(75, 23);
            this.buttonConsultComment.TabIndex = 2;
            this.buttonConsultComment.Text = "Consulter";
            this.buttonConsultComment.UseVisualStyleBackColor = true;
            this.buttonConsultComment.Click += new System.EventHandler(this.buttonConsultComment_Click);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(46, 22);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(32, 13);
            this.label7.TabIndex = 1;
            this.label7.Text = "ISBN";
            this.label7.Click += new System.EventHandler(this.label7_Click);
            // 
            // textBoxISBNCommenaire
            // 
            this.textBoxISBNCommenaire.Location = new System.Drawing.Point(20, 38);
            this.textBoxISBNCommenaire.Name = "textBoxISBNCommenaire";
            this.textBoxISBNCommenaire.Size = new System.Drawing.Size(100, 20);
            this.textBoxISBNCommenaire.TabIndex = 0;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(484, 40);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(128, 13);
            this.label8.TabIndex = 5;
            this.label8.Text = "Résultats de la recherche";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(39, 308);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(35, 13);
            this.label9.TabIndex = 6;
            this.label9.Text = "label9";
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(461, 339);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.tabConnecte);
            this.Controls.Add(this.buttonDeconnexion);
            this.Controls.Add(this.listView1);
            this.Controls.Add(this.buttonConnexion);
            this.Controls.Add(this.tabAbonne);
            this.Name = "Form1";
            this.Text = "Interface abonné";
            this.tabAbonne.ResumeLayout(false);
            this.tabRecherche.ResumeLayout(false);
            this.tabRecherche.PerformLayout();
            this.tabConnecte.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.tabPage2.ResumeLayout(false);
            this.tabPage2.PerformLayout();
            this.tabPage3.ResumeLayout(false);
            this.tabPage3.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TabControl tabAbonne;
        private System.Windows.Forms.TabPage tabRecherche;
        private System.Windows.Forms.Button buttonRechercheISBN;
        private System.Windows.Forms.Button buttonRechercheAuteur;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox textRehercheISBN;
        private System.Windows.Forms.TextBox textRechercheAuteur;
        private System.Windows.Forms.Button buttonConnexion;
        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.ColumnHeader Auteur;
        private System.Windows.Forms.ColumnHeader Titre;
        private System.Windows.Forms.ColumnHeader ISBN;
        private System.Windows.Forms.ColumnHeader Exemplaires;
        private System.Windows.Forms.Button buttonDeconnexion;
        private System.Windows.Forms.TabControl tabConnecte;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox textBoxISBN2;
        private System.Windows.Forms.TextBox textBoxAuteur;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBoxCommenaire;
        private System.Windows.Forms.TextBox textBoxISBN;
        private System.Windows.Forms.Button button3;
        private System.Windows.Forms.TabPage tabPage3;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox textBoxISBNCommenaire;
        private System.Windows.Forms.Button buttonConsultComment;
        private System.Windows.Forms.ListView listView2;
        private System.Windows.Forms.ColumnHeader columnCommentaire;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
    }
}

