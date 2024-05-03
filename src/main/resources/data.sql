-- Insert users
INSERT INTO app_users (username, password, email) VALUES ('ali', 'password123', 'ali@gmail.com' );
INSERT INTO app_users (username, password, email) VALUES ('bader', 'password456', 'bader@gmail.com' );
INSERT INTO app_users (username, password, email) VALUES ('khalid', 'password789', 'khalid@gmail.com' );

-- Insert lists
INSERT INTO todo_lists (title, user_id) VALUES ('Home Chores', 1);
INSERT INTO todo_lists (title, user_id) VALUES ('Work Tasks', 2);
INSERT INTO todo_lists (title, user_id) VALUES ('Workouts', 3);

-- Insert items
INSERT INTO todo_items (description, status, due_date, created_at, todo_list_id) VALUES ('Clean the house', 'PENDING', '2024-12-20', CURRENT_TIMESTAMP(), 1);
INSERT INTO todo_items (description, status, due_date, created_at, todo_list_id) VALUES ('Wash the floor', 'PENDING', '2024-12-26', CURRENT_TIMESTAMP(), 1);

INSERT INTO todo_items (description, status, due_date, created_at, todo_list_id) VALUES ('Prepare meeting notes', 'PENDING', '2024-12-22', CURRENT_TIMESTAMP(), 2);

INSERT INTO todo_items (description, status, due_date, created_at, todo_list_id) VALUES ('Bench press', 'PENDING', '2024-12-25', CURRENT_TIMESTAMP(), 3);
INSERT INTO todo_items (description, status, due_date, created_at, todo_list_id) VALUES ('Deadlift', 'PENDING', '2024-12-25', CURRENT_TIMESTAMP(), 3);

