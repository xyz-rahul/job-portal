import React from 'react';
import './errorPage.css';
import { isRouteErrorResponse, useRouteError } from 'react-router-dom';

export default function ErrorPage() {
  const error = useRouteError();

  return (
    <div className="error-container">
      <h1>An error has occurred.</h1>
      <h1>
        <span className="ascii">{error.message}</span>
      </h1>
      <h3>
        <span className="ascii">{error.code}</span>
      </h3>
      <a href="/">Go Home</a> 
    </div>
  );
}
