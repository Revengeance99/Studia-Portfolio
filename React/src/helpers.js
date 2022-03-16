export const selectMovies = (movies, filter) => {
  let result = [];
  let compare = filter.toLowerCase();
  movies.forEach((m) => {
    if (
      m.title.toLowerCase().includes(compare) ||
      m.director.toLowerCase().includes(compare)
    ) {
      result.push(m);
    }
  });

  return result;
};
