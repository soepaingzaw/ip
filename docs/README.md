# User Guide

Hello! This UI app is built to help manage your tasks better!

## Features

 **todo** adds tasks you have to the list
 
 **deadline** adds tasks that are due in the future to your list
 
 **event** adds special occasions that are happening in the future to your list
 
 **list** displays all the task you have
 
 **done** checks off a task you completed
 
 **find** to find if a particular task exists in your list by typing in key words 
 
 **delete** to remove task from your list


## Usage

### `todo` - type todo followed by a general task you currently have

This adds the "todo" task in your list

Example of usage: 

`todo math homework`

Expected outcome in list:

`[T][✘] math homework`

### `deadline` - type `deadline` followed by a task then write `/by` followed by the day and time which you have to complete it

This adds the "deadline" task in your list with the day and time added

Example of usage: 

`deadline form submission /by Monday 12pm`

Expected outcome in list:

`[D][✘] form submission (by: Monday 12pm)`

### `event` - type `event` followed by a task then write `/at` followed by the day and time period which you will be attending said event

This adds the "event" task in your list with the day and time period added

Example of usage: 

`event Sean's Birthday Party /at Friday 7-11pm`

Expected outcome in list:

`[E][✘] Sean's Birthday Party (at: Friday 7-11pm)`

### `list` - type `list` to display all tasks, deadlines and events

Example of usage: 

`list`

Expected outcome:

`1.[T][✘] math homework`  
`2.[D][✘] form submission (by: Monday 12pm)`  
`3.[E][✘] Sean's Birthday Party (at: Friday 7-11pm)`  

### `done` - type `done` followed by the numeration of the task you have completed

Using the example in `list`:

Example of usage: 

`done 2`

Expected outcome:

`Nice! I've marked this task as done:`  
`[D][✓] form submission (by: Monday 12pm)`  

### `find` - type `find` followed by the word you are searching for in a task

Using the example in `list`:

Example of usage: 

`find Birthday`

Expected outcome:

`1.[E][✘] Sean's Birthday Party (at: Friday 7-11pm)` 

### `delete` - type `delete` followed by the numeration of the task you want to remove from the list

Using the example in `list`:

Example of usage: 

`delete 1`

Expected outcome:

`Noted. I've removed this task:`  
`[T][✘] math homework`  
`Now you have 2 task(s) in the list.`     






