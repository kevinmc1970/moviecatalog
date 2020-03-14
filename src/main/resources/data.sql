--drop table director cascade;
--drop table movie cascade;
--drop table rating cascade;
MERGE INTO director (id, name) VALUES
  (1, 'Steven Spielberg'),
  (2, 'George Lucas');

MERGE INTO movie (id, name, director_id) VALUES
  (1, 'E.T.', 1),
  (2, 'Star Wars', 2);

MERGE INTO rating (id, reviewer_name, percentage_rating, movie_id) VALUES
  (1, 'Empire', 80, 1),
  (2, 'Mark Kermode', 79, 1);
