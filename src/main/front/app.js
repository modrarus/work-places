import 'bootstrap/dist/css/bootstrap.min.css';
import React, {Component} from "react";
import ReactDOM from "react-dom";
import { Button, ButtonGroup } from 'reactstrap';

class App extends Component {
	render() {
		return (
			<div>
				<Header/>
				<h1>Hello, world!</h1>
			</div>
		)
	}
}

class Header extends Component {
	render() {
		return(
			<ButtonGroup>
				<Button>Телефонная книга</Button>
				<Button>Места работы</Button>
			</ButtonGroup>
		)
	}
}

ReactDOM.render(<App />, document.getElementById('react-main'))