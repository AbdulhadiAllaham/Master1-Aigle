namespace AdministratorForm
{
    partial class Form2
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.tabAbonneConnecte = new System.Windows.Forms.TabControl();
            this.tabAddAbone = new System.Windows.Forms.TabPage();
            this.buttonCreerAbonne = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.textPswAbone = new System.Windows.Forms.TextBox();
            this.textNomAbonne = new System.Windows.Forms.TextBox();
            this.tabAddLivre = new System.Windows.Forms.TabPage();
            this.bouttonAddLIvre = new System.Windows.Forms.Button();
            this.labelNmbExemplaire = new System.Windows.Forms.Label();
            this.labelEditeur = new System.Windows.Forms.Label();
            this.labelISBN = new System.Windows.Forms.Label();
            this.labelTitre = new System.Windows.Forms.Label();
            this.labelAuteur = new System.Windows.Forms.Label();
            this.textBoxEditeur = new System.Windows.Forms.TextBox();
            this.textBoxExemplaire = new System.Windows.Forms.TextBox();
            this.textBoxIsbn = new System.Windows.Forms.TextBox();
            this.textBoxTitre = new System.Windows.Forms.TextBox();
            this.textBoxAuteur = new System.Windows.Forms.TextBox();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.buttonDeconnexion = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.tabAbonneConnecte.SuspendLayout();
            this.tabAddAbone.SuspendLayout();
            this.tabAddLivre.SuspendLayout();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.tabAbonneConnecte);
            this.groupBox1.Controls.Add(this.tabControl1);
            this.groupBox1.Location = new System.Drawing.Point(65, 21);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(405, 292);
            this.groupBox1.TabIndex = 0;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Gestion administrateur";
            // 
            // tabAbonneConnecte
            // 
            this.tabAbonneConnecte.Controls.Add(this.tabAddAbone);
            this.tabAbonneConnecte.Controls.Add(this.tabAddLivre);
            this.tabAbonneConnecte.Location = new System.Drawing.Point(24, 30);
            this.tabAbonneConnecte.Name = "tabAbonneConnecte";
            this.tabAbonneConnecte.SelectedIndex = 0;
            this.tabAbonneConnecte.Size = new System.Drawing.Size(359, 239);
            this.tabAbonneConnecte.TabIndex = 5;
            // 
            // tabAddAbone
            // 
            this.tabAddAbone.Controls.Add(this.buttonCreerAbonne);
            this.tabAddAbone.Controls.Add(this.label4);
            this.tabAddAbone.Controls.Add(this.label3);
            this.tabAddAbone.Controls.Add(this.textPswAbone);
            this.tabAddAbone.Controls.Add(this.textNomAbonne);
            this.tabAddAbone.Location = new System.Drawing.Point(4, 22);
            this.tabAddAbone.Name = "tabAddAbone";
            this.tabAddAbone.Padding = new System.Windows.Forms.Padding(3);
            this.tabAddAbone.Size = new System.Drawing.Size(351, 213);
            this.tabAddAbone.TabIndex = 0;
            this.tabAddAbone.Text = "Ajouter abonné";
            this.tabAddAbone.UseVisualStyleBackColor = true;
            // 
            // buttonCreerAbonne
            // 
            this.buttonCreerAbonne.Location = new System.Drawing.Point(148, 128);
            this.buttonCreerAbonne.Name = "buttonCreerAbonne";
            this.buttonCreerAbonne.Size = new System.Drawing.Size(100, 23);
            this.buttonCreerAbonne.TabIndex = 5;
            this.buttonCreerAbonne.Text = "Créer abonné";
            this.buttonCreerAbonne.UseVisualStyleBackColor = true;
            this.buttonCreerAbonne.Click += new System.EventHandler(this.button2_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(22, 58);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(72, 13);
            this.label4.TabIndex = 5;
            this.label4.Text = "Mot de Passe";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(22, 20);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(78, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "Nom Utilisateur";
            // 
            // textPswAbone
            // 
            this.textPswAbone.Location = new System.Drawing.Point(148, 55);
            this.textPswAbone.Name = "textPswAbone";
            this.textPswAbone.PasswordChar = '*';
            this.textPswAbone.Size = new System.Drawing.Size(100, 20);
            this.textPswAbone.TabIndex = 2;
            // 
            // textNomAbonne
            // 
            this.textNomAbonne.Location = new System.Drawing.Point(148, 17);
            this.textNomAbonne.Name = "textNomAbonne";
            this.textNomAbonne.Size = new System.Drawing.Size(100, 20);
            this.textNomAbonne.TabIndex = 1;
            // 
            // tabAddLivre
            // 
            this.tabAddLivre.Controls.Add(this.bouttonAddLIvre);
            this.tabAddLivre.Controls.Add(this.labelNmbExemplaire);
            this.tabAddLivre.Controls.Add(this.labelEditeur);
            this.tabAddLivre.Controls.Add(this.labelISBN);
            this.tabAddLivre.Controls.Add(this.labelTitre);
            this.tabAddLivre.Controls.Add(this.labelAuteur);
            this.tabAddLivre.Controls.Add(this.textBoxEditeur);
            this.tabAddLivre.Controls.Add(this.textBoxExemplaire);
            this.tabAddLivre.Controls.Add(this.textBoxIsbn);
            this.tabAddLivre.Controls.Add(this.textBoxTitre);
            this.tabAddLivre.Controls.Add(this.textBoxAuteur);
            this.tabAddLivre.Location = new System.Drawing.Point(4, 22);
            this.tabAddLivre.Name = "tabAddLivre";
            this.tabAddLivre.Padding = new System.Windows.Forms.Padding(3);
            this.tabAddLivre.Size = new System.Drawing.Size(351, 213);
            this.tabAddLivre.TabIndex = 1;
            this.tabAddLivre.Text = "Ajouter Livre";
            this.tabAddLivre.UseVisualStyleBackColor = true;
            // 
            // bouttonAddLIvre
            // 
            this.bouttonAddLIvre.Location = new System.Drawing.Point(205, 179);
            this.bouttonAddLIvre.Name = "bouttonAddLIvre";
            this.bouttonAddLIvre.Size = new System.Drawing.Size(75, 23);
            this.bouttonAddLIvre.TabIndex = 10;
            this.bouttonAddLIvre.Text = "Ajouter Livre";
            this.bouttonAddLIvre.UseVisualStyleBackColor = true;
            this.bouttonAddLIvre.Click += new System.EventHandler(this.bouttonAddLIvre_Click);
            // 
            // labelNmbExemplaire
            // 
            this.labelNmbExemplaire.AutoSize = true;
            this.labelNmbExemplaire.Location = new System.Drawing.Point(24, 132);
            this.labelNmbExemplaire.Name = "labelNmbExemplaire";
            this.labelNmbExemplaire.Size = new System.Drawing.Size(98, 13);
            this.labelNmbExemplaire.TabIndex = 9;
            this.labelNmbExemplaire.Text = "Nombre Exemplaire";
            // 
            // labelEditeur
            // 
            this.labelEditeur.AutoSize = true;
            this.labelEditeur.Location = new System.Drawing.Point(24, 106);
            this.labelEditeur.Name = "labelEditeur";
            this.labelEditeur.Size = new System.Drawing.Size(40, 13);
            this.labelEditeur.TabIndex = 8;
            this.labelEditeur.Text = "Editeur";
            // 
            // labelISBN
            // 
            this.labelISBN.AutoSize = true;
            this.labelISBN.Location = new System.Drawing.Point(26, 80);
            this.labelISBN.Name = "labelISBN";
            this.labelISBN.Size = new System.Drawing.Size(32, 13);
            this.labelISBN.TabIndex = 7;
            this.labelISBN.Text = "ISBN";
            // 
            // labelTitre
            // 
            this.labelTitre.AutoSize = true;
            this.labelTitre.Location = new System.Drawing.Point(26, 51);
            this.labelTitre.Name = "labelTitre";
            this.labelTitre.Size = new System.Drawing.Size(28, 13);
            this.labelTitre.TabIndex = 6;
            this.labelTitre.Text = "Titre";
            // 
            // labelAuteur
            // 
            this.labelAuteur.AutoSize = true;
            this.labelAuteur.Location = new System.Drawing.Point(24, 25);
            this.labelAuteur.Name = "labelAuteur";
            this.labelAuteur.Size = new System.Drawing.Size(38, 13);
            this.labelAuteur.TabIndex = 5;
            this.labelAuteur.Text = "Auteur";
            // 
            // textBoxEditeur
            // 
            this.textBoxEditeur.Location = new System.Drawing.Point(194, 103);
            this.textBoxEditeur.Name = "textBoxEditeur";
            this.textBoxEditeur.Size = new System.Drawing.Size(100, 20);
            this.textBoxEditeur.TabIndex = 3;
            this.textBoxEditeur.TextChanged += new System.EventHandler(this.textBoxEditeur_TextChanged);
            // 
            // textBoxExemplaire
            // 
            this.textBoxExemplaire.Location = new System.Drawing.Point(194, 129);
            this.textBoxExemplaire.Name = "textBoxExemplaire";
            this.textBoxExemplaire.Size = new System.Drawing.Size(100, 20);
            this.textBoxExemplaire.TabIndex = 4;
            // 
            // textBoxIsbn
            // 
            this.textBoxIsbn.Location = new System.Drawing.Point(194, 77);
            this.textBoxIsbn.Name = "textBoxIsbn";
            this.textBoxIsbn.Size = new System.Drawing.Size(100, 20);
            this.textBoxIsbn.TabIndex = 2;
            // 
            // textBoxTitre
            // 
            this.textBoxTitre.Location = new System.Drawing.Point(194, 48);
            this.textBoxTitre.Name = "textBoxTitre";
            this.textBoxTitre.Size = new System.Drawing.Size(100, 20);
            this.textBoxTitre.TabIndex = 1;
            // 
            // textBoxAuteur
            // 
            this.textBoxAuteur.Location = new System.Drawing.Point(194, 22);
            this.textBoxAuteur.Name = "textBoxAuteur";
            this.textBoxAuteur.Size = new System.Drawing.Size(100, 20);
            this.textBoxAuteur.TabIndex = 0;
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Location = new System.Drawing.Point(25, 30);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(358, 239);
            this.tabControl1.TabIndex = 0;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.label2);
            this.tabPage1.Controls.Add(this.label1);
            this.tabPage1.Controls.Add(this.button1);
            this.tabPage1.Controls.Add(this.textBox2);
            this.tabPage1.Controls.Add(this.textBox1);
            this.tabPage1.Location = new System.Drawing.Point(4, 22);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(350, 213);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Connexion";
            this.tabPage1.UseVisualStyleBackColor = true;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(59, 77);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(72, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "Mot de Passe";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(59, 39);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(78, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "Nom Utilisateur";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(193, 150);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 2;
            this.button1.Text = "Connexion";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(179, 74);
            this.textBox2.Name = "textBox2";
            this.textBox2.PasswordChar = '*';
            this.textBox2.Size = new System.Drawing.Size(100, 20);
            this.textBox2.TabIndex = 1;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(179, 34);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 0;
            // 
            // buttonDeconnexion
            // 
            this.buttonDeconnexion.Location = new System.Drawing.Point(224, 339);
            this.buttonDeconnexion.Name = "buttonDeconnexion";
            this.buttonDeconnexion.Size = new System.Drawing.Size(117, 23);
            this.buttonDeconnexion.TabIndex = 1;
            this.buttonDeconnexion.Text = "Deconnexion";
            this.buttonDeconnexion.UseVisualStyleBackColor = true;
            this.buttonDeconnexion.Click += new System.EventHandler(this.buttonDeconnexion_Click);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(561, 389);
            this.Controls.Add(this.buttonDeconnexion);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form2";
            this.Text = "Interface Administrateur";
            this.groupBox1.ResumeLayout(false);
            this.tabAbonneConnecte.ResumeLayout(false);
            this.tabAddAbone.ResumeLayout(false);
            this.tabAddAbone.PerformLayout();
            this.tabAddLivre.ResumeLayout(false);
            this.tabAddLivre.PerformLayout();
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TabControl tabAbonneConnecte;
        private System.Windows.Forms.TabPage tabAddAbone;
        private System.Windows.Forms.TabPage tabAddLivre;
        private System.Windows.Forms.Button buttonCreerAbonne;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.TextBox textPswAbone;
        private System.Windows.Forms.TextBox textNomAbonne;
        private System.Windows.Forms.TextBox textBoxTitre;
        private System.Windows.Forms.TextBox textBoxAuteur;
        private System.Windows.Forms.TextBox textBoxEditeur;
        private System.Windows.Forms.TextBox textBoxExemplaire;
        private System.Windows.Forms.TextBox textBoxIsbn;
        private System.Windows.Forms.Label labelAuteur;
        private System.Windows.Forms.Label labelISBN;
        private System.Windows.Forms.Label labelTitre;
        private System.Windows.Forms.Label labelEditeur;
        private System.Windows.Forms.Label labelNmbExemplaire;
        private System.Windows.Forms.Button bouttonAddLIvre;
        private System.Windows.Forms.Button buttonDeconnexion;
    }
}