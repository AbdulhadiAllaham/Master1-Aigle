<?php
class Todo
{
	private $_params;
	
	public function __construct($params)
	{
		$this->_params = $params;
	}
	
	public function createAction()
	{
		//create a new todo item
		$todo = new TodoItem();
		$todo->title = $this->_params['title'];
		$todo->description = $this->_params['description'];
		$todo->due_date = $this->_params['due_date'];
		$todo->is_done = 'false';
		$todo->lieu = $this->_params['lieu'];

		//pass the user's username and password to authenticate the user
		$todo->save($this->_params['username'], $this->_params['userpass']);
		
		//return the todo item in array format
		return $todo->toArray();
	}
	
	public function readAction()
	{
		//charger les taches en passant le "username" et le mot de passe
		$todo_items = TodoItem::getAllItems($this->_params['username'], $this->_params['userpass']);
		
		//retourner les taches existantes
		return $todo_items;
	}
	
	public function updateAction()
	{
		//récupérer la tâche à modifier dans une variable php
		$todo = TodoItem::getItem($this->_params['todo_id'], $this->_params['username'], $this->_params['userpass']);
		
		//mettre à jour les différents paramètres (titre, lieu etc.)
		$todo->title = $this->_params['title'];
		$todo->description = $this->_params['description'];
		$todo->due_date = $this->_params['due_date'];
		$todo->lieu = $this->_params['lieu'];
		$todo->is_done = $this->_params['is_done'];
		
		//pass the user's username and password to authenticate the user
		$todo->save($this->_params['username'], $this->_params['userpass']);
		
		//return the todo item in array format
		return $todo->toArray();
	}
	
	public function deleteAction()
	{
		//récupérer la tâche à supprimer
		$todo = TodoItem::getItem($this->_params['todo_id'], $this->_params['username'], $this->_params['userpass']);
		
		//supprimer la tâche en passant les informations d'authentifaction
		$todo->delete($this->_params['username'], $this->_params['userpass']);
		
		//return the todo item in array format
		return $todo->toArray();
	}
}
