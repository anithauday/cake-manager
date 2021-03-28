import React from 'react'
import { Form, Button, Icon } from 'semantic-ui-react'

function CakeForm({ cakeDescription,title,image, handleInputChange, handleCreateCake }) {
  const createBtnDisabled = cakeDescription.trim() === ''
  return (
    <Form onSubmit={handleCreateCake}>
      <Form.Group>
        <Form.Input
          name='cakeDescription'
          placeholder='Description *'
          value={cakeDescription}
          onChange={handleInputChange}
        />

        <Form.Input
            name='title'
            placeholder='title *'
            value={title}
            onChange={handleInputChange}
        />

        <Form.Input
            name='image'
            placeholder='image *'
            value={image}
            onChange={handleInputChange}
        />

        <Button icon labelPosition='right' disabled={createBtnDisabled}>
          Create<Icon name='add' />
        </Button>
      </Form.Group>
    </Form>
  )
}

export default CakeForm