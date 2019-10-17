
import { mount } from '@vue/test-utils'
import Category from '../../../../src/modules/Category/category';
import CategoryService from '@/services/category.service'

jest.mock('@/services/category.service', () =>  ({
  getAll: jest.fn().mockResolvedValue({})
}))

describe('Category component', () => {
  let component 
  beforeEach(() => {
    component = mount(Category);
  });
  
  // nós podemos resetar o mock assim
  // afterEach(() => CategoryService.getAll.mockReset());

  
  it('Should message equals to `Hello World`', () => {
    expect(component.vm.message).toEqual('Hello World');
  });

  it('Should message equals to `Hello Aceleradora 16`', () => {
    component.setData({ message: 'Hello Aceleradora 16'});
    expect(component.vm.message).toEqual('Hello Aceleradora 16');
  });

  it('Should Call `CategoryService.getAll`', () => {
    expect(CategoryService.getAll).toHaveBeenCalled();
  });
});