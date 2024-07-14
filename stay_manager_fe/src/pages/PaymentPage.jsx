import React from 'react';
import PaymentComponent from '../components/PaymentComponent';
import { BrowserRouter as Router} from 'react-dom';
import { Route, Switch } from 'react-dom';

const PaymentPage = () => {
  return (
    <Router>
      <Switch>
        <Route exact path="/payments" component={PaymentComponent} />
      </Switch>
    </Router>
  );
};

export default PaymentPage;
