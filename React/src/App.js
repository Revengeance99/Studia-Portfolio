import React, { useState } from "react";
import Header from "./components/Header";
import SearchBar from "./components/SearchBar";
import Catalog from "./components/Catalog";
import Footer from "./components/Footer";
import { Container } from "react-bootstrap";

const App = () => {
  const [filmFilter, setFilmFilter] = useState(null);

  const userSearch = (data) => {
    setFilmFilter(data);
  };

  return (
    <>
      <Container>
        <Header />
        <SearchBar userSearch={userSearch} />
        <Catalog filter={filmFilter} />
      </Container>
      <Footer />
    </>
  );
};

export default App;

// npm install -g firebase-tools
