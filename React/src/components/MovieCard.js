import React from "react";
import { Card } from "react-bootstrap";

const MovieCard = ({ movie }) => {
  return (
    <Card className="movieCard">
      <Card.Body>
      <Card.Img variant="top" src={movie.img} />
        <Card.Title>{movie.title}</Card.Title>
        <Card.Subtitle className="mb-2 text-muted">
          {movie.director}
        </Card.Subtitle>
        <Card.Text>{movie.description}</Card.Text>
        <Card.Link href={movie.link} target="_blank" rel="noopener noreferrer">
          Znajdź!
        </Card.Link>
      </Card.Body>
    </Card>
  );
};

export default MovieCard;
