import 'bootstrap/dist/css/bootstrap.min.css';
import React, {Component} from "react";
import ReactDOM from "react-dom";
import { Button, ButtonGroup, Container } from 'reactstrap';
import WorkPlacesList, {WorkPlaceCreateDialog} from "./WorkPlaces";
import PhonesBook from "./PhoneBook";
import { BrowserRouter, Route, Switch, Link } from "react-router-dom";

class App extends Component {
	render() {
		return (
			<Container>
				<BrowserRouter>
					<Link to="/phonebook"><Button>Телефонная книга</Button></Link>
					<Link to="/"><Button>Места работы</Button></Link>
					<br />
					<Switch>
						<Route exact path='/' component={WorkPlacesList}/>
						<Route path='/workplace/create' component={WorkPlaceCreateDialog}/>
						<Route path='/phonebook' component={PhonesBook}/>
					</Switch>
				</BrowserRouter>
			</Container>
		)
	}
}

ReactDOM.render(<App />, document.getElementById('react-main'))