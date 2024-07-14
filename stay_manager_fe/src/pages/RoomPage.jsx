import React from 'react';
import RoomListComponent from '../components/RoomListComponent';
import RoomDetailComponent from '../components/RoomDetailComponent';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

const RoomPage = () => {
  return (
    <Router>
      <Switch>
        <Route exact path="/rooms" component={RoomListComponent} />
        <Route path="/rooms/:id" component={RoomDetailComponent} />
      </Switch>
    </Router>
  );
};

export default RoomPage;
