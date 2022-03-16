import React from "react";
import MovieCard from "./MovieCard";
import { movies } from "../data";
import { selectMovies } from "../helpers";

const Catalog = ({ filter }) => {
  var moviesToDiplay = filter ? selectMovies(movies, filter) : movies;

  return (
    <div className="catalog">
      {moviesToDiplay.map((movie) => (
        <MovieCard movie={movie} key={movie.id} />
      ))}
    </div>
  );
};

export default Catalog;
