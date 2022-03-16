import React from "react";
import { Button, Jumbotron } from "react-bootstrap";

const Header = () => {
  return (
    <Jumbotron className="jumbo">
      <h1 className="jumbo__title">Katalog Samochodowy</h1>
      <p className="jumbo__text">
        Znajdź swoje wymarzone auto w okazyjnej cenie!
      </p>
    </Jumbotron>
  );
};

export default Header;
