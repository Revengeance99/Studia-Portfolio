import React from "react";
import { Row, Col, Container } from "react-bootstrap";

const Footer = () => {
  return (
    <div className="footer">
      <Container>
        <Row>
          <Col>
            <h4>Katalog Samochodowy</h4>
            Najpopularniejsze marki samochodów
            <p className="header__description">
              Created by Grzegorz Krzesiński
            </p>
          </Col>
          <Col>
            <h5>Przydatne linki</h5>
            <div className="links">
              <ul>
                <li>
                  <a
                    className="footer__link"
                    href="https://www.otomoto.pl/"
                    target="_blank"
                    rel="noopener noreferrer"
                  >
                    Baza samochodów otomoto.pl
                  </a>
                </li>
                <li>
                  <a
                    className="footer__link"
                    href="https://www.olx.pl/motoryzacja/samochody/"
                    target="_blank"
                    rel="noopener noreferrer"
                  >
                    Motoryzacja OLX
                  </a>
                </li>
                <li>
                  <a
                    className="footer__link"
                    href="https://www.autoscout24.pl/"
                    target="_blank"
                    rel="noopener noreferrer"
                  >
                    Zagraniczny rynek
                  </a>
                </li>
              </ul>
            </div>
          </Col>
        </Row>
      </Container>
    </div>
  );
};

export default Footer;
