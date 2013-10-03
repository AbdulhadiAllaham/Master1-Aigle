namespace AbonneForm
{
    partial class FormConnexion
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
            this.labelNom = new System.Windows.Forms.Label();
            this.labelPsw = new System.Windows.Forms.Label();
            this.textBoxNomUtilisateur = new System.Windows.Forms.TextBox();
            this.textBoxPSW = new System.Windows.Forms.TextBox();
            this.buttonConnexion = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // labelNom
            // 
            this.labelNom.AutoSize = true;
            this.labelNom.Location = new System.Drawing.Point(52, 40);
            this.labelNom.Name = "labelNom";
            this.labelNom.Size = new System.Drawing.Size(84, 13);
            this.labelNom.TabIndex = 0;
            this.labelNom.Text = "Nom d\'utilisateur";
            // 
            // labelPsw
            // 
            this.labelPsw.AutoSize = true;
            this.labelPsw.Location = new System.Drawing.Point(52, 107);
            this.labelPsw.Name = "labelPsw";
            this.labelPsw.Size = new System.Drawing.Size(71, 13);
            this.labelPsw.TabIndex = 1;
            this.labelPsw.Text = "Mot de passe";
            // 
            // textBoxNomUtilisateur
            // 
            this.textBoxNomUtilisateur.Location = new System.Drawing.Point(255, 33);
            this.textBoxNomUtilisateur.Name = "textBoxNomUtilisateur";
            this.textBoxNomUtilisateur.Size = new System.Drawing.Size(148, 20);
            this.textBoxNomUtilisateur.TabIndex = 2;
            // 
            // textBoxPSW
            // 
            this.textBoxPSW.Location = new System.Drawing.Point(255, 104);
            this.textBoxPSW.Name = "textBoxPSW";
            this.textBoxPSW.PasswordChar = '*';
            this.textBoxPSW.Size = new System.Drawing.Size(148, 20);
            this.textBoxPSW.TabIndex = 3;
            // 
            // buttonConnexion
            // 
            this.buttonConnexion.Location = new System.Drawing.Point(276, 166);
            this.buttonConnexion.Name = "buttonConnexion";
            this.buttonConnexion.Size = new System.Drawing.Size(102, 23);
            this.buttonConnexion.TabIndex = 4;
            this.buttonConnexion.Text = "Se connecter";
            this.buttonConnexion.UseVisualStyleBackColor = true;
            this.buttonConnexion.Click += new System.EventHandler(this.buttonConnexion_Click);
            // 
            // FormConnexion
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(459, 201);
            this.Controls.Add(this.buttonConnexion);
            this.Controls.Add(this.textBoxPSW);
            this.Controls.Add(this.textBoxNomUtilisateur);
            this.Controls.Add(this.labelPsw);
            this.Controls.Add(this.labelNom);
            this.Name = "FormConnexion";
            this.Text = "Connexion Abonné";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label labelNom;
        private System.Windows.Forms.Label labelPsw;
        private System.Windows.Forms.TextBox textBoxNomUtilisateur;
        private System.Windows.Forms.TextBox textBoxPSW;
        private System.Windows.Forms.Button buttonConnexion;

    }
}