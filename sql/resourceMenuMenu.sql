-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网络资源-种子目录', '3', '1', '/content/resourceMenu', 'C', '0', 'content:resourceMenu:view', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '网络资源-种子目录菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网络资源-种子目录查询', @parentId, '1',  '#',  'F', '0', 'content:resourceMenu:list',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网络资源-种子目录新增', @parentId, '2',  '#',  'F', '0', 'content:resourceMenu:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网络资源-种子目录修改', @parentId, '3',  '#',  'F', '0', 'content:resourceMenu:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu  (menu_name, parent_id, order_num, url,menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('网络资源-种子目录删除', @parentId, '4',  '#',  'F', '0', 'content:resourceMenu:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');
