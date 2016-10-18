DELETE FROM line;
DELETE FROM uploadrequest;

INSERT INTO uploadrequest(id)
VALUE (1);

INSERT INTO line(value_of_line, counter, request_id) VALUES
  ('When you want to take a nap, the violin will wake you up.', 2, 1),
  ('You want to help me, Alan? Find a gun and shoot me in the eye.', 3, 1);